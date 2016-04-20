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
        public int Id { get; set; }
        public int Row { get; set; }
        public int Column { get; set; }
        public bool IsOpen { get; set; }
        public ICommand SelectCardCommand { get; set; }

        private String _Color;
        public String Color
        {
            get { return _Color; }
            set
            {
                _Color = value;
                NotifyPropertyChanged("Color");
            }
        }

        public void SelectCard()
        {
            this.Color = "Gray";
            this.IsOpen = true;
        }

        public Card(int id, int row, int column, string color)
        {
            this.Id = id;
            this.Row = row;
            this.Column = column;
            this.Color = color;
            this.IsOpen = false;

            SelectCardCommand = new SelectCardCommand();
        }

        private void NotifyPropertyChanged(String propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}
