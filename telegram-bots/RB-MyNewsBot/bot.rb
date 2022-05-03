#!/usr/bin/ruby
# encoding: utf-8

require 'telegram/bot'
require 'twitter'

#path assoloto di dove si trova lo script ( è una variabile globale)
$absolute_path = ARGV[0]

#configurazione per l'accesso a twitter
#ritorna un oggetto client
def setUpTwConn()
	client = Twitter::REST::Client.new do |config|
		config.consumer_key        = "KlNDFclNPgquj9Rt7DwzFaK9E"
		config.consumer_secret     = "1K4pbBCXyPvqRjWvVffHPiFHVPOgOSJtq54l3FZoW6FWMPwpMR"
		config.access_token        = "3218579897-MGV4J36C1Pez4mTMp1SE7YkCFPG0Lr6R9j5V9TR"
		config.access_token_secret = "k8PYlZY2D30ZGal9qHybVEWpt2BJB9iZKqDAA0qi89eSp"
	end
	return client
end

#configurazione della sorgente per il singolo utente
#necessita un array di stringhe e una string contenente l'id della chat
def setSource(splitted_message,chat_id)
	#controllo che il messaggio contenga solo il comanda e il parametro
	if splitted_message[0] == "/setsource" && splitted_message[1] != nil
		if checkSource(splitted_message[1])
			#creazione del file utente
			file = File.open($absolute_path+"users/"+chat_id,"w")
			
			#scrittura dell'argomento nel file
			file.write(splitted_message[1])
			#chiusa del file
			file.close

			#buon fine
			return 0
		else
			return 2
		end
	else
		#mancato argomento
		return 1
	end

end

def getSource(id)
	begin
		file = File.open($absolute_path+"users/"+id,"r")

		source = file.read
	
		file.close
	
		return source
	rescue
		return nil
	end
end

def checkSource(source)
	client = setUpTwConn()
	begin
		client.user_timeline(source).take(1)
		return true
	rescue
		return false
	end
end

def getTweetsFromSource(source,client,number)
	return client.user_timeline(source).take(number)
end
#prende un determinato numero di tweet
#ritorna un array di tweets
def getTweets(client,number)
	return client.user_timeline("wireditalia").take(number)
end

#converte un singolo oggetto tweet in string
#ritorna una stringa
def tweetToS(tweet)
	str = tweet.text+"\n"
	return str.to_s
end

#funzione per analizzare il testo del tweet e prendere i links
#ritorna un array con testo del tweet ed eventiali link
def tweetToArray(tweet)
	#split del testo per gli spazi
	text = tweet.text.to_s.split(" ")

	#Dichiarazione di array contenente testo e eventuali links
	links = Array.new(0)
	links.push(tweet.text[0,tweet.text.index('https')])

	#Controllo di quanti link sono presenti nel testo
	if text.last.to_s.include?("https")
		#aggiunta del link all'array
		links.push(text[-1])
	end
	if text[text.length-2].to_s.include?("https")
		#aggiunta del link all'array
		links.push(text[-2])
	end

	#return del array
	return links
end


TOKEN = "276163063:AAFOsBOEHeBADQ0rTk_BpeOaEzOQVvVowYQ"
Telegram::Bot::Client.run(TOKEN) do |bot|
	bot.listen do |message|
		#start
		if message.text.to_s == "/start"
			bot.api.send_message(chat_id: message.chat.id, text: "Benvenuto #{message.from.first_name} ! Sei curioso di sapere qualche nuova notizia ?")
		end
		#-------------------------------------------------------------------------------------------------------------------------------------------------
		
		#help
		if message.text.to_s == "/help"
			bot.api.send_message(chat_id: message.chat.id, text: "#{message.from.first_name} mi sa che hai bisogno di aiuto !\nEccoti una lista di cose che questo bot può fare:\n\n  news --> ti manda l'ultimo tweet\n  random --> prende un tweet a caso tra gli ultimi 10\nNuove a breve ...")
		end
		#--------------------------------------------------------------------------------------------------------------------------------------------------
		
		#showsource
		if message.text.to_s == "/showsource"
			source = getSource(message.chat.id.to_s)
			if source == nil
				bot.api.send_message(chat_id: message.chat.id, text: "Accidebolina !\nNon hai specificato la sorgente da cui prendere le new.\nProva con /setsource <nome_sorgente>")
			else
				bot.api.send_message(chat_id: message.chat.id, text: "La sorgente attuale è:\n"+source)
			end
		end
		#--------------------------------------------------------------------------------------------------------------------------------------------------

		#configurazione file utente
		if message.text.to_s.downcase.include?("/setsource")
			array = message.text.to_s.downcase.split(" ")
			#print array[1]
			if setSource(array,message.chat.id.to_s) == 0
				#messaggio di conferma operazione
				bot.api.send_message(chat_id: message.chat.id, text: "Ce l'hai fatta !\nHai configurato con successo il bot !")
			elsif setSource(array,message.chat.id.to_s) == 2
				bot.api.send_message(chat_id: message.chat.id, text: "Credo che la sorgete inserita sia inesistente ...")
			else
				#messaggio di errori nell' operazione
				bot.api.send_message(chat_id: message.chat.id, text: "Mi sa che hai dimendicato di inserire la sorgente ...")
			end
		end
		#--------------------------------------------------------------------------------------------------------------------------------------------------

		#news e random
		if message.text.to_s.downcase.include?("news")
			#instaura la connessione con le api di twitter
			client = setUpTwConn()

			source = getSource(message.chat.id.to_s)
			if source == nil
				bot.api.send_message(chat_id: message.chat.id, text: "Accidebolina !\nNon hai specificato la sorgente da cui prendere le new.\nProva con /setsource <nome_sorgente>")
			else
				#prende l'ultimo tweet
				tweet = getTweetsFromSource(source,client,1)
				#genera l'array per l'imaginazione del messaggio
				split_text = tweetToArray(tweet[0])

				#se ci sono 2 link nel testo invia una foto
				if split_text.length == 2
					#catch delle eccezzioni perche qualcuno metti i link fallati
					begin
						bot.api.send_photo(chat_id: message.chat.id, photo: "#{split_text.last}", caption: "#{split_text[0]}\n ( #{split_text[1]} )")
					rescue
						bot.api.send_message(chat_id: message.chat.id, text: "#{split_text.first}\n( #{split_text[1]} )")
					end
				#altrimenti un messaggio di testo
				else
					bot.api.send_message(chat_id: message.chat.id, text: "#{split_text.first}\n ( #{split_text.last} )")
				end
			end
		elsif message.text.to_s.downcase.include?("random")
			client = setUpTwConn()
			source = getSource(message.chat.id.to_s)
			if source == nil
				bot.api.send_message(chat_id: message.chat.id, text: "Accidebolina !\nNon hai specificato la sorgente da cui prendere le new.\nProva con /setsource <nome_sorgente>")
			else
				tweet = getTweetsFromSource(source,client,10)
				split_text = tweetToArray(tweet[Random.rand(0...10)])

				if split_text.length == 2
					#catch delle eccezzioni perche qualcuno metti i link fallati
					begin
						bot.api.send_photo(chat_id: message.chat.id, photo: "#{split_text.last}", caption: "#{split_text[0]}\n ( #{split_text[1]} )")
					rescue
						bot.api.send_message(chat_id: message.chat.id, text: "#{split_text.first}\n( #{split_text[1]} )")
					end
				else
					bot.api.send_message(chat_id: message.chat.id, text: "#{split_text.first}\n ( #{split_text.last} )")
				end
			end
		end
		#-----------------------------------------------------------------------------------------------------------------------------------------------

	end
end
