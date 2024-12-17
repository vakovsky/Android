https://github.com/vakovsky/Android/tree/main/csAndroid

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary1
{
    public enum TransportType { Train, Bus, Taxi }

    public class Transport
    {
        //Вътрешни параметри Z
        private double таксиНачалнаТакса = 0.70; //лв
        private double таксиДневнаТарифа = 0.79; //лв./км.
        private double таксиНощнаТарифа = 0.90; //лв./км.
        private double автобусДневнаНощнаТарифа = 0.09; //лв./км.
        private double автобусРазстоянияМинимум = 20; //км
        private double влакДневнаНощнаТарифа = 0.06; //лв./км.
        private double влакРазстоянияМинимум = 100; //км.
        //Входни параметри  X
        public int N { get; set; }
        public string DayOrNight { get; set; }
        //Изходни параметри Y
        public TransportType TransportType { get; private set; }
        public double Price
        {
            get
            {
                if (N >= влакРазстоянияМинимум)
                {
                    TransportType = TransportType.Train;
                    return N * влакДневнаНощнаТарифа;
                }
                else
                {
                    if (N >= автобусРазстоянияМинимум)
                    {
                        TransportType = TransportType.Bus;
                        return N * автобусДневнаНощнаТарифа;
                    }
                    else
                    {
                        TransportType = TransportType.Taxi;
                        if (DayOrNight == "day")
                        {
                            return таксиНачалнаТакса + N * таксиДневнаТарифа;
                        }
                        else
                        {
                            return таксиНачалнаТакса + N * таксиНощнаТарифа;
                        }
                    }
                }
            }
        }

        public override string ToString()
        {
            return N.ToString() + " км.през " + DayOrNight.ToString() + " цена: " + Price.ToString("f2") + " лв. тип " + TransportType;
        }
    }
}
