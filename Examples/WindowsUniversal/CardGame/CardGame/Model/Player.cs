using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CardGame.Model
{
    public class Player : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public string Name { get; set; }

        public Player(String Name)
        {
            this.Name = Name;
            this.Score = 0;
        }

        private int score;

        public int Score
        {
            get { return score; }
            set { score = value; NotifyPropertyChanged("Score"); }
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
