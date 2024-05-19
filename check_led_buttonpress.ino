// Description : This program has an LED and checks if the push button is pressed and acts upon it.

int data = 0;

void setup() {
  pinMode(6, INPUT);
  pinMode(12, OUTPUT);
}

void loop() {
  data = digitalRead(6);

  if (data == 1) {
    digitalWrite(12, HIGH);
  }
  
  else {
    digitalWrite(12, LOW);
  }
 }
