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
        public static List<Card> Cards { get; set; }
        private static Card Selection { get; set; }

        public int Size { get; set; }

        public CardGameViewModel()
        {
            Size = 2;

            Cards = new List<Card>(2);
            Cards.Add(new Card(1, 0, 0, "Blue"));
            Cards.Add(new Card(2, 1, 1, "Red"));
        }

        internal static void ChangeSelection(Card parameter)
        {
            CardGameViewModel.Selection = parameter;
        }
    }
}
