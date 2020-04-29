package pl.patrykkazimierowski;

import javax.swing.*;

public abstract class Horner {



    public static int obliczenia(int wspolczynniki[], int stopienWielomianu, int argumentWielomianu)
    {

        if(stopienWielomianu == 0)
        {
            int i = wspolczynniki[0];
            return i;
        }

        return argumentWielomianu*obliczenia(wspolczynniki,stopienWielomianu-1,argumentWielomianu) + wspolczynniki[stopienWielomianu];
    }

    public static int wspolczynnikSafeMode(int stopien)
    {
        int wynik;

        String inputTemp;
        String komunikat;

        try {
            inputTemp = JOptionPane.showInputDialog("Podaj wspolczynnik stojacy przy " + (stopien) + " potedze");
            wynik = Integer.parseInt(inputTemp);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Podales bledna wartosc sprobuj jeszcze raz");
            wynik = wspolczynnikSafeMode(stopien);
        }
        return wynik;
    }

    public static boolean textFieldIntSafeMode(JTextField field)
    {
        int tempWynik;
        try {
            tempWynik = Integer.parseInt(field.getText());
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }

}
