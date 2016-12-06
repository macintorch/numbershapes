package ainor.com.my.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);

            // test if a double is integer
            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }


        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }
    }



    public void testNumberFunction (View view) {

        String message = "";

        EditText usersNumber = (EditText) findViewById(R.id.usersNumberEditText);

        if (usersNumber.getText().toString().isEmpty()) {
            message = "Please enter number";
        } else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(usersNumber.getText().toString());


            if (myNumber.isSquare()) {

                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is both triangular and square!";
                } else {
                    message = myNumber.number + " is square but not triangular";
                }

            } else {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is triangular but not square ";
                } else {
                    message = myNumber.number + " is neither square nor triangular";
                }
            }



            System.out.println();

        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        Log.i("Users Number", usersNumber.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
