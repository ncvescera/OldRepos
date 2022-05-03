#include <DHT.h>

// Connect VIN to 3-5VDC
// Connect GND to ground
// Connect SCL to I2C clock pin
// Connect SDA to I2C data pin



#define DHTPIN        36
#define RISCALDAMENTO 30 //relaise 1
#define UMIDIFICATORI 31 //relaise 2, fanno partire anche le ventole
#define ASPIRAZIONE   32 //relaise 3
//#define <<NOME>> 33

#define MAX_TEMP  25.0
#define MIN_TEMP  25.0
#define MAX_HUM   90.0

DHT dht(DHTPIN, DHT22); //// Initialize DHT sensor for normal 16mhz Arduino

void setup()
{
  Serial.begin(9800);
  Serial.println("GY-21_test");

  dht.begin();

  //inizializzzazione porte relaise
  pinMode(RISCALDAMENTO, OUTPUT);
  pinMode(UMIDIFICATORI, OUTPUT);
  pinMode(ASPIRAZIONE, OUTPUT);
  
}

void loop()
{
  float temp  = dht.readTemperature();
  float hum   = dht.readHumidity();

  printSensorData(temp, hum);  

  //accendiRelaise(RISCALDAMENTO);
  gestoreRiscaldamento(temp);
  gestoreAspirazione(temp, hum);
  gestioneUmidificatori(hum);
  
  delay(500);
}

void printSensorData(float temp, float hum)
{
  Serial.print("Temp: ");
  Serial.print(temp);
  Serial.print("°C    ");
  Serial.print("Humidity: ");
  Serial.print(hum);
  Serial.print("\%    ");

  Serial.print("Riscaldamento ");
  Serial.print(digitalRead(RISCALDAMENTO));
  Serial.print("    ");

  Serial.print("Aspirazione ");
  Serial.print(digitalRead(ASPIRAZIONE));
  Serial.print("    ");

  Serial.print("Umidificatori ");
  Serial.println(digitalRead(UMIDIFICATORI));
}

void accendiRelaise(int relaise)
{
  digitalWrite(relaise, HIGH);
}

void spegniRelaise(int relaise)
{
  digitalWrite(relaise, LOW);
}

void gestoreRiscaldamento(float temp)
{
  float variazione = 1.0;

  if (temp > MAX_TEMP + variazione)
  {
    spegniRelaise(RISCALDAMENTO);
  }
  else if (temp < MIN_TEMP - variazione)
  {
    accendiRelaise(RISCALDAMENTO);
  }
  
}

void gestoreAspirazione(float temp, float hum)
{
  float variazione_temp = 3.0;
  float variazione_hum = 5.0;

  if (temp > MAX_TEMP + variazione_temp || hum > MAX_HUM + variazione_hum)
  {
    accendiRelaise(ASPIRAZIONE);
  }
  else {
    if (temp <= MAX_TEMP && hum <= MAX_HUM) 
    {
      spegniRelaise(ASPIRAZIONE);
    }
  }
  
}

void gestioneUmidificatori(float hum)
{
  float veriazione = 10.0;

  if (hum <= MAX_HUM - veriazione)
  {
    accendiRelaise(UMIDIFICATORI);
  }
  else
  {
    if (hum >= MAX_HUM)
    {
      spegniRelaise(UMIDIFICATORI);
    }
  }
}
