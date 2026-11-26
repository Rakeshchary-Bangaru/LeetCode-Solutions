class Solution {
    public boolean canAliceWin(int n) {
         boolean alice = true;
        int stones = 10;

        while (n >= stones) {

            n -= stones;

            stones--;

            alice = !alice;
        }

        return !alice;


    }
}