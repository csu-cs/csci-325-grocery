


    public class listManagement{

        public void add(List k, String name, int quantity)
        {

            Items addedItem = new Items(name, quantity);
            addedItem.previous = k.head;
            addedItem.next = null;
            k.head = addedItem;

        }





    } // Handles the communication and sending of the lists. Handled by Martin


