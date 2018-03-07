import javax.swing.JTextArea;
import javax.swing.JTextField;
public class CalculosDP{
    public float gradosCF(float celsius){
        float farenheit = (float)celsius*9/5+32;
        return farenheit;
    }
    public float gradosFC(float farenheit){
        float celsius = (float)(farenheit-32)*5/9;
        return celsius;
    }
    public int factorial(int number){
        int result = 1;
        for(int i = number; i>0; i--){
            result = result*number;
            number--;
        }
        return result;
    }
    public float exponencial(int b, int e){
        float result = 1;
        if(e >= 0){
            if(e == 0){
                return (1);
            }
            for(int i = 0; i < e; i++){
                result = result*b;
            }
        }
        else{
            e = e*-1;
            for(int i = 0; i < e; i++){
                result = result*b;
            }
            result = 1/result;
        }
        return(result);
    }
    public static String ecuacion(int a, int b, int c)
    {
        String strA, strB, strC;
        String resultado="";
        int radical;
        float x, x1, x2;
        if(a == 0)
        {
            if(b==0)
            {
                resultado = "No hay Ecuacion, por lo tanto no hay raices...";
            }
            else
            {
                x = -(float)c/b;
                resultado = "Ecuacion Lineal X = "+x;
            }
        }
        else
        {
            radical = b*b - 4*a*c; 
            if(radical < 0)
            {
                resultado = "Raices Imginarias...";
            }
            else
            {
                x1 = (-b - (float)Math.sqrt(radical)) / (2*a);
                x2 = (-b + (float)Math.sqrt(radical)) / (2*a);
                resultado = "Raices Reales\nX1 = "+x1+"\nX2 = "+x2;
            }
        }
        return resultado;
    }
    public static String tabla (int a){
        String s="";
        for(int i = 0; i<=10; i++){
            double result = a*i;
            s= s + a +"x"+ i+"="+ result+"\n";  
        }
        return s;
    }
}