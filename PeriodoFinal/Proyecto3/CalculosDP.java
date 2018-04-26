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
    public void ecuacion(JTextField tfCoefA, JTextField tfCoefB, JTextField tfCoefC, JTextArea taOut){
        int a,b,c;
            a = Integer.parseInt(tfCoefA.getText());
            b = Integer.parseInt(tfCoefB.getText());
            c = Integer.parseInt(tfCoefC.getText());
            if(a == 0){
                if(b == 0){
                    taOut.setText("Error, no existe la ecuacion.");
                }
                else{
                    float x = (float) -c/b;
                    taOut.setText("Ecuacion lineal 'x' es igual a: "+ x);
                }
            }
            else{
                int i = (b*b)-(4*a*c);
                if(i < 0){
                    taOut.setText("Raices Imaginarias.");
                }
                else{
                    float x1, x2;
                    x1 =(float) (-b + Math.sqrt(i))/(2*a);
                    x2 =(float) (-b - Math.sqrt(i))/(2*a);
                    taOut.setText("Las Raices son:"+"\nx1: "+x1+"\nx2: "+x2);
                }
            }
    }
}