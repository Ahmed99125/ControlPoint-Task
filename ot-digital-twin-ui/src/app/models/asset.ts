export interface Asset {
  id: number;
  name: string;
  type: string;
  status: string;
  // to be able to hold all the data inside asset
  lastReading?: SensorReading;
}

export interface SensorReading {
  id: number;
  temperature: number;
  pressure: number;
  timestamp: string;
}