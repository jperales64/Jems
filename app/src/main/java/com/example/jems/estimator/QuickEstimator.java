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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class QuickEstimator extends AppCompatActivity {
    double projectCost = 0;
    int employeeNum = 0;
    final double EMPLOYEE_PAY_HR = 15.00;
    final double DRYWALL_COST = 40.00;
    double employeeTotalPay = 0;
    double timeEstimate = 0;
    double totalEstimate = 0.00;
    double materialCost = 0;
    NumberFormat nf = NumberFormat.getCurrencyInstance();

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


        projectCostDisplayLabel.setText(nf.format(projectCost));

        totalCostDisplay.setText(nf.format(totalEstimate));

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
                                                            foundationType("Laminate");
                                                            break;
                                                        case 1:
                                                            foundationType("Wood");
                                                            break;
                                                        case 2:
                                                            foundationType("Tile");
                                                            break;

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
                                    typeBuilder.setItems(new CharSequence[]{"Interior", "Exterior"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            paintingSqFtDialog(3.00);
                                                            break;
                                                        case 1:
                                                            paintingSqFtDialog(2.00);
                                                            break;
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();


                                } else if(projectType.equals("Drywall")){
                                    sqFtDialog(DRYWALL_COST);

                                } else if(projectType.equals("Cabinet")){
                                    typeBuilder.setItems(new CharSequence[]{"Pre-Fabricated", "Custom"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            materialType("Pre-Fabricated");
                                                            break;
                                                        case 1:
                                                            cabinetEstimate();
                                                            break;
                                                    }
                                                }

                                                private void cabinetEstimate() {
                                                    AlertDialog.Builder alert = new AlertDialog.Builder(QuickEstimator.this);
                                                    alert.setTitle("Enter Custom Estimate");

                                                    final EditText input = new EditText(QuickEstimator.this);
                                                    alert.setView(input);
                                                    input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


                                                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int whichButton) {
                                                            String value = input.getText().toString();
                                                            Log.d("", "Pin Value : " + value);
                                                            projectCost = Double.parseDouble(value);
                                                            projectCostDisplayLabel.setText(nf.format(projectCost));
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
                                            });
                                    typeBuilder.create().show();

                                } else if (projectType.equals("Pre-Fabricated")){

                                    typeBuilder.setItems(new CharSequence[]{"Raw", "Painted"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            panelType("Raw");
                                                            break;
                                                        case 1:
                                                            panelType("Painted");
                                                            break;

                                                    }
                                                }

                                                private void panelType(String type) {
                                                    double cost = 0;
                                                    if (type.equals("Raw")) {
                                                        cost = 150.00;
                                                    }else if (type.equals("Painted")){
                                                        cost = 300.00;
                                                    }
                                                    projectCostDisplayLabel.setText(nf.format(cost));
                                                }
                                            });
                                    typeBuilder.create().show();

                                } else if (projectType.equals("Bathroom Tiling")){

                                    typeBuilder.setItems(new CharSequence[]{"Value", "Moderate", "Deluxe"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            sqFtDialog(2.00);
                                                            break;
                                                        case 1:
                                                            sqFtDialog(5.00);
                                                            break;
                                                        case 2:
                                                            sqFtDialog(7.00);
                                                            break;
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();

                                } else if (projectType.equals("Bathroom Shower")){
                                    typeBuilder.setItems(new CharSequence[]{"Tile", "Hardware", "Door"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            materialType("Shower Tile");
                                                            break;
                                                        case 1:
                                                            materialType("Shower Hardware");
                                                            break;
                                                        case 2:
                                                            materialType("Shower Door");
                                                            break;
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();

                                } else if (projectType.equals("Shower Tile")){
                                    typeBuilder.setItems(new CharSequence[]{"Value", "Moderate", "Quality"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            sqFtDialog(18.00);
                                                            break;
                                                        case 1:
                                                            sqFtDialog(25.00);
                                                            break;
                                                        case 2:
                                                            sqFtDialog(32.00);
                                                            break;
                                                    }
                                                }
                                            });
                                    typeBuilder.create().show();

                                } else if (projectType.equals("Shower Hardware")){
                                    typeBuilder.setItems(new CharSequence[]{"Value", "Moderate", "Quality"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            projectCost = 80.00;
                                                            break;
                                                        case 1:
                                                            projectCost = 150.00;
                                                            break;
                                                        case 2:
                                                            projectCost = 300.00;
                                                            break;
                                                    }
                                                    projectCostDisplayLabel.setText(nf.format(projectCost));
                                                }
                                            });
                                    typeBuilder.create().show();

                                } else if (projectType.equals("Shower Door")){
                                    typeBuilder.setItems(new CharSequence[]{"Frameless", "Framed"},
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which) {
                                                        case 0:
                                                            projectCost = 1000.00;
                                                            break;
                                                        case 1:
                                                            projectCost = 300.00;
                                                            break;
                                                    }
                                                    projectCostDisplayLabel.setText(nf.format(projectCost));
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

                            private void paintingSqFtDialog(final double materialsCost) {
                                AlertDialog.Builder alert = new AlertDialog.Builder(QuickEstimator.this);
                                alert.setTitle("Enter Square Footage");

                                final EditText input = new EditText(QuickEstimator.this);
                                alert.setView(input);
                                input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);


                                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        String value = input.getText().toString();
                                        Log.d("", "Pin Value : " + value);
                                        projectCost = Double.parseDouble(value) * materialsCost;
                                        projectCostDisplayLabel.setText(nf.format(projectCost));
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

                            private void foundationType(final String flooringType) {
                                final AlertDialog.Builder foundationBuilder = new AlertDialog.Builder(QuickEstimator.this);

                                if (flooringType.equals("Laminate")){
                                    materialCost = 1.00;
                                }else if (flooringType.equals("Wood")){
                                    materialCost = 5.00;
                                } else if (flooringType.equals("Tile")){
                                    materialCost = 7.00;
                                }

                                foundationBuilder.setTitle("Choose Foundation Type");
                                foundationBuilder.setItems(new CharSequence[]{"Beam", "Concrete"},
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                switch (which) {
                                                    case 0:
                                                        materialCost += 6.00;
                                                        break;
                                                    case 1:
                                                        materialCost += 7.00;
                                                        break;
                                                }
                                                sqFtDialog(materialCost);
                                                return;
                                            }
                                        });
                                foundationBuilder.create().show();

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
                                        distanceDialog(projectCost);
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

                            private void distanceDialog(final double projectCost) {
                                AlertDialog.Builder alert = new AlertDialog.Builder(QuickEstimator.this);
                                alert.setTitle("Enter Distance in Miles");

                                final EditText input = new EditText(QuickEstimator.this);
                                alert.setView(input);
                                input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        String value = input.getText().toString();
                                        Log.d("", "Pin Value : " + value);
                                        double totalCost = projectCost + (Double.parseDouble(value) * 0.10);
                                        projectCostDisplayLabel.setText(nf.format(totalCost));

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

                totalCostDisplay.setText(nf.format(totalEstimate));
            }
        });

    }


}
