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

        public bool CanExecute(object parameter)
        {
            return ((Card)parameter).IsOpen == false;
        }

        public void Execute(object parameter)
        {
            ((Card)parameter).SelectCard();
            CardGameViewModel.ChangeSelection((Card)parameter);

            RaiseCanExecuteChanged();
        }

        public void RaiseCanExecuteChanged()
        {
            var handler = CanExecuteChanged;
            if (handler != null)
            {
                handler(this, EventArgs.Empty);
            }
        }
    }
}
