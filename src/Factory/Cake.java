package Factory;

public class Cake implements IItem{
        private int Price = 2;
        private int size = 0;
        public Cake(int Size){
            this.size = Size;

            if(size == 6){
                Price = 20;
            }
            if(size == 9){
                Price = 25;
            }
        }
        @Override
        public int getPrice() {
            // TODO Auto-generated method stub
            return Price;
        }
}
