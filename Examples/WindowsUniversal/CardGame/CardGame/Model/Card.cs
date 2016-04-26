using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace CardGame.Model
{
    public class Card : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        public int Id { get; set; }
        public Color ColorType { get; }

        public Card(int id, string color, Color ColorType)
        {
            this.Id = id;
            this.Color = color;
            this.IsOpen = false;
            this.ColorType = ColorType;
        }

        private bool isOpen;
        public bool IsOpen
        {
            get { return isOpen; }
            set { isOpen = value; NotifyPropertyChanged("Color"); }
        }


        private String _Color;
        public String Color
        {
            get
            {
                return IsOpen ? _Color : "Gray";
            }
            set
            {
                _Color = value;
            }
        }

        private void NotifyPropertyChanged(String propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }
    }
}
