package com.example.jems.estimator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.content.DialogInterface;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jems.R;
import com.example.jems.materials.MaterialType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class QuickEstimator extends AppCompatActivity {
    double projectCost = 0;
    int employeeNum = 0;
    final double EMPLOYEE_PAY_HR = 15.00;
    double employeeTotalPay = 0;
    double timeEstimate = 0;
    double totalEstimate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quick_estimator);
        final TextView projectCostDisplayLabel = (TextView) findViewById(R.id.projectCostDisplayLabel);
        final TextView employeesNumField = (TextView) findViewById((R.id.employeesNumField));
        final TextView estimatedHrsField = (TextView) findViewById((R.id.estimatedHrsField));
        final TextView totalCostDisplay = (TextView) findViewById(R.id.totalCostDisplay);
        final Button selectProjectButton = (Button) findViewById(R.id.selectProjectButton);
        final Button calculateEstimateButton = (Button) findViewById(R.id.calculateEstimateButton);


        projectCostDisplayLabel.setText("$" + projectCost);

        totalCostDisplay.setText("$" + totalEstimate);

        selectProjectButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(QuickEstimator.this);
                builder.setTitle("Choose Project Type");
                builder.setItems(new CharSequence[]
                                {"Flooring", "Bathroom", "Drywall", "Painting", "Cabinet"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                switch (which) {
                                    case 0:
                                        materialType("Flooring");
                                        break;
                                    case 1:
                                        materialType("Bathroom");
                                        break;
                                    case 2:
                                        materialType("Drywall");
                                        break;
                                    case 3:
                                        materialType("Painting");
                                        break;
                                    case 4:
                                        materialType("Cabinet");
                                        break;

                                }
                            }

                            private void materialType(String projectType) {
                                AlertDialog.Builder typeBuilder = new AlertDialog.Builder(QuickEstimator.this);

                                typeBuilder.setTitle("Choose Material Type");

                                if (projectType.equals("Flooring")) {
                                    typeBuilder.setItems(new CharSequence[]{"Laminate", "Wood", "Tile"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            Toast.makeText(QuickEstimator.this, "Laminate Flooring", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();


                                } else if(projectType.equals("Bathroom")){
                                    typeBuilder.setTitle("Choose Bathroom Project Type");
                                    typeBuilder.setItems(new CharSequence[]{"Tiling", "Shower"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            materialType("Bathroom Tiling");
                                                            break;
                                                        case 1:
                                                            materialType("Bathroom Shower");
                                                            break;
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();


                                } else if(projectType.equals("Painting")){
                                    typeBuilder.setItems(new CharSequence[]{"Interior", "Exterior", ""},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            materialType("Interior");
                                                            break;
                                                        case 1:
                                                            materialType("Exterior");
                                                            break;
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();


                                } else if(projectType.equals("Drywall")){
                                    sqFtDialog(40.00);

                                } else if(projectType.equals("Cabinet")){
                                    typeBuilder.setItems(new CharSequence[]{"", "", ""},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            Toast.makeText(QuickEstimator.this, "", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();


                                } else if (projectType.equals("Bathroom Tiling")){
                                    typeBuilder.setItems(new CharSequence[]{"", "", ""},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            Toast.makeText(QuickEstimator.this, "", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();

                                } else if (projectType.equals("Bathroom Shower")){
                                    typeBuilder.setItems(new CharSequence[]{"Laminate", "Wood", "Tile"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            Toast.makeText(QuickEstimator.this, "Laminate Flooring", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();

                                }else if(projectType.equals("Painting Interior")){
                                    typeBuilder.setItems(new CharSequence[]{"", "", ""},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            Toast.makeText(QuickEstimator.this, "", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();


                                }else if(projectType.equals("Painting Exterior")){
                                    typeBuilder.setItems(new CharSequence[]{"", "", ""},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            Toast.makeText(QuickEstimator.this, "", Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();

                                }
                            }

                            private void sqFtDialog(final double materialCost) {
                                AlertDialog.Builder alert = new AlertDialog.Builder(QuickEstimator.this);
                                alert.setTitle("Enter Square Footage");

                                final EditText input = new EditText(QuickEstimator.this);
                                alert.setView(input);
                                input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


                                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        String value = input.getText().toString();
                                        Log.d("", "Pin Value : " + value);
                                        projectCost = Double.parseDouble(value) * materialCost;
                                        projectCostDisplayLabel.setText("$" + projectCost);
                                        return;
                                    }
                                });

                                alert.setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                return;
                                            }
                                        });
                                alert.show();
                            }

                            private void distanceDialog() {
                                AlertDialog.Builder alert = new AlertDialog.Builder(QuickEstimator.this);
                                alert.setTitle("Enter Distance");

                                final EditText input = new EditText(QuickEstimator.this);
                                alert.setView(input);
                                input.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);

                                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        String value = input.getText().toString();
                                        Log.d("", "Pin Value : " + value);
                                        return;
                                    }
                                });

                                alert.setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                // TODO Auto-generated method stub
                                                return;
                                            }
                                        });
                                alert.show();
                            }
                        });
                builder.create().show();

            }
        });

        calculateEstimateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //projectCost = Double.parseDouble(projectCostDisplayLabel.getText().toString());
                employeeNum = Integer.parseInt(employeesNumField.getText().toString());
                employeeTotalPay = employeeNum * EMPLOYEE_PAY_HR;
                timeEstimate = Integer.parseInt(estimatedHrsField.getText().toString());
                totalEstimate = (employeeTotalPay * timeEstimate) + projectCost;

                //Toast.makeText(QuickEstimator.this, String.valueOf(totalEstimate), Toast.LENGTH_SHORT).show();

                totalCostDisplay.setText("$" + String.valueOf(totalEstimate));
            }
        });

    }

}
