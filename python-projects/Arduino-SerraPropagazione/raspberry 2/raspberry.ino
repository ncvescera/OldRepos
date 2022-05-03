#include "DHT.h"

#define SIZE(x) ( sizeof(x) / sizeof( (x)[0] ) )

//########################
//Pin

int pin_ventole[] = {14, 15, 16};

int pin_lampada       = 18;
int pin_pompa         = 19;
int pin_led           = 17;

int pin_reset_sensore = 25;

DHT dht(7, DHT22);  //Sensore Umidità Temperatura
//########################

void setup() {
  Serial.begin(9600); //Comunicazione Seriale
  dht.begin();

  pinMode(pin_reset_sensore, OUTPUT);
  digitalWrite(pin_reset_sensore, LOW);

  pinMode(pin_led, OUTPUT);
  digitalWrite(pin_led, LOW);

  pinMode(pin_lampada, OUTPUT);
  digitalWrite(pin_lampada, HIGH);

  pinMode(pin_pompa, OUTPUT);
  digitalWrite(pin_pompa, HIGH);

  for(int i = 0; i < SIZE(pin_ventole); i++){
    pinMode(pin_ventole[i], OUTPUT);
    digitalWrite(pin_ventole[i], HIGH);
  }
}

void loop() {
  static char incoming = 0;

  if(Serial.available() > 0) {
    incoming = Serial.read();

    if(incoming == 'p') {
      digitalWrite(pin_pompa, HIGH);
    } else if(incoming == 'P') {
        digitalWrite(pin_pompa, LOW);
    } else if(incoming == 'v') {
        for(int i = 0; i < SIZE(pin_ventole); i++) {
          digitalWrite(pin_ventole[i], HIGH);
        }
    } else if(incoming == 'V') {
        for(int i = 0; i < SIZE(pin_ventole); i++) {
          digitalWrite(pin_ventole[i], LOW);
        }
    } else if(incoming == 'l') {
        digitalWrite(pin_lampada, HIGH);
    } else if(incoming == 'L') {
        digitalWrite(pin_lampada, LOW);
    } else if(incoming == 'k') {
        digitalWrite(pin_led, HIGH);
    } else if(incoming == 'K') {
        digitalWrite(pin_led, LOW);
    } else if(incoming == 'S') {
        digitalWrite(pin_reset_sensore, LOW);
    } else if(incoming == 's') {
        digitalWrite(pin_reset_sensore, HIGH);
    }

  }

  soil();
  Serial.print(';');

  read_temp();
  Serial.print(';');

  read_humid();
  Serial.print(';');

  int livellometro = analogRead(A1);
  Serial.print(livellometro);
  Serial.print('\n');

  delay(1000);
}

float read_temp() {
  float t = dht.readTemperature(); // Leggo il valore di temperatura

  if (isnan(t)){
    Serial.print("Impossibile leggere il sensore!");
    //digitalWrite(pin_reset_sensore, HIGH);
    //digitalWrite(pin_reset_sensore, LOW);

  } else { //altrimenti
      Serial.print("Temperatura: ");
      Serial.print(t);
      Serial.print(" *C");
  }

  return t;
}

float read_humid() {
  float h = dht.readHumidity(); // Leggo il valore di umidità

  if (isnan(h)){ // Se almeno uno dei due valori è NaN (Not a Number)
    Serial.print("Impossibile leggere il sensore!");
  } else { //altrimenti
      Serial.print("Umidità: ");
      Serial.print(h);
  }

  return h;
}

const int AirValue = 880;   //you need to replace this value with Value_1
const int WaterValue = 464;  //you need to replace this value with Value_2
int intervals = (AirValue - WaterValue)/3;

int soil(){
  //630 bagnato ottimale
  /* https://randomnerdtutorials.com/guide-for-soil-moisture-sensor-yl-69-or-hl-69-with-the-arduino/ */

  /*
  int sensorValue = analogRead(A0);
  Serial.print("Soil: ");
  Serial.println(sensorValue);
  */

  int soilMoistureValue = analogRead(A0);  //put Sensor insert into soil
  Serial.print(soilMoistureValue);

  if(soilMoistureValue > WaterValue && soilMoistureValue < (WaterValue + intervals)) {
    //Serial.print(soilMoistureValue);
    Serial.print(" Very Wet");
    //digitalWrite(pin_pompa, HIGH);

  } else if(soilMoistureValue > (WaterValue + intervals) && soilMoistureValue < (AirValue - intervals)) {
      Serial.print(" Wet");
      //digitalWrite(pin_pompa, HIGH);
      //digitalWrite(pin_pompa, LOW);

  } else if(soilMoistureValue < AirValue && soilMoistureValue > (AirValue - intervals)) {
      Serial.print(" Dry");
      //digitalWrite(pin_pompa, LOW);
      //digitalWrite(pin_pompa, HIGH);

  } else {
    //Serial.print("\n");
    //digitalWrite(pin_pompa, HIGH);

  }

  return soilMoistureValue;
}
