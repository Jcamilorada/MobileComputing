using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace CardGame.Model
{
    public class CardGameViewModel
    {
        public List<Card> Cards { get; set; }
        public Player PlayingPlayer { get; set; }
        public ICommand SelectCardCommand { get; set; }
        public int Size { get; set; }
        public List<Player> Players { get; set;}

        private Card _SelectedCard;

        private int _PlayersNumber;
        private int _PlayerIndex = 0;

        public CardGameViewModel()
        {
            Size = 2;
            SelectCardCommand = new SelectCardCommand(this);

            Cards = new List<Card>(4);
            Cards.Add(new Card(1,"Blue", Color.Blue));
            Cards.Add(new Card(2, "Red", Color.Red));
            Cards.Add(new Card(3, "Blue", Color.Blue));
            Cards.Add(new Card(4, "Red", Color.Red));

            _PlayersNumber = 2;
            Players = new List<Player>(_PlayersNumber);
            Players.Add(new Player("Juan"));
            Players.Add(new Player("Diana"));

            PlayingPlayer = Players.ElementAt(_PlayerIndex);
        }

        internal async void UpdateSelection(Card card)
        {
            card.IsOpen = true;
            await Task.Delay(700);

            if (_SelectedCard == null)
            {
                _SelectedCard = card;
            }

            else
            {
                if (_SelectedCard.Color == card.Color)
                {
                    PlayingPlayer.Score++;
                }

                else
                {
                    _SelectedCard.IsOpen = false;
                    card.IsOpen = false;
                }

                _SelectedCard = null;
                _PlayerIndex = _PlayerIndex == (_PlayersNumber - 1) ? 0 : _PlayerIndex + 1;
                PlayingPlayer = Players.ElementAt(_PlayerIndex);
            }
        }
    }
}
