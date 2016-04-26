using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace CardGame.Model
{
    public class SelectCardCommand : ICommand
    {
        public event EventHandler CanExecuteChanged;

        private CardGameViewModel _CardGameViewModel;

        public SelectCardCommand(CardGameViewModel  cardViewModel)
        {
            this._CardGameViewModel = cardViewModel;
        }

        public bool CanExecute(object parameter)
        {
            return true;
        }

        public void Execute(object parameter)
        { 
            _CardGameViewModel.UpdateSelection(((Card)parameter));
        }
    }
}
