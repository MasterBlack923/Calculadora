package Calculadora;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.awt.event.ActionListener;

public class CalculadoraVentana extends JFrame {

    public JTextField cajaTexto = new JTextField();

    public String acumulat = "0";
    public boolean bol_suma = false;
    public boolean bol_resta = false;

    public boolean bol_multi = false;

    public boolean bol_div = false;

    public boolean bol_porc = false;

    public double nombre1;
    public double nombre2;

    public String resultatfinal;
    public double resultat = 0;

    public String operacio = "";

    public JPanel panel;
    public CalculadoraVentana(){
        this.setSize(205,358);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculadora");
        //setLocation(100,200);
        //setBounds(100,200,500,500);
        setLocationRelativeTo(null); //Fer apareixer la finestra al centre
        this.getContentPane().setBackground(Color.DARK_GRAY);
        iniciarComponentes();
    }

    private void iniciarComponentes(){
        colocarPaneles();
        colocarCajasDeTexto();
        //colocarEtiquetas();
        //colocarRadioBotones();
        controlNumeros();
        colocarBotones();
        //colocarListasDesplegables();
    }

    private void colocarPaneles() {
        panel = new JPanel(); //Creació d'un panell
        panel.setBounds(2,5,50,50);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        this.getContentPane().add(panel); //Afegim el panell a la finestra

    }

    public void colocarEtiquetas() {

        JLabel etiqueta = new JLabel(); //Creem una etiqueta
        //etiqueta.setOpaque(true);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //Centrar el tect
        etiqueta.setBounds(10,45,170,80);
        etiqueta.setForeground(Color.BLACK); //Color de la lletra de l'etiqueta
        //etiqueta.setBackground(Color.BLACK); //Color del fons de l'etiqueta
        etiqueta.setFont(new Font("arial",1,20)); //Establim la font del text
        panel.add(etiqueta); //Afegim l'etiqueta al panell
    }

    private void colocarBotones(){
        //Etiqueta
        JLabel etiqueta = new JLabel(); //Creem una etiqueta
        //etiqueta.setOpaque(true);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //Centrar el tect
        etiqueta.setBounds(60,45,400,80);
        etiqueta.setForeground(Color.BLACK); //Color de la lletra de l'etiqueta
        //etiqueta.setBackground(Color.BLACK); //Color del fons de l'etiqueta
        etiqueta.setFont(new Font("arial",1,15)); //Establim la font del text
        panel.add(etiqueta); //Afegim l'etiqueta al panell

        JButton boton1 = new JButton();
        boton1.setText("AC"); // Text del boto
        boton1.setBounds(0, 75, 55, 55);
        boton1.setHorizontalAlignment(SwingConstants.CENTER);
        boton1.setEnabled(true); // Boto ON o OFF
        boton1.setBackground(Color.darkGray);
        //boton1.setMnemonic('a');
        boton1.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente13= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre1 = 0;
                nombre2 = 0;
                acumulat = "0";
                resultat = 0;
                resultatfinal = "0";
                bol_suma = false;
                bol_resta = false;
                bol_multi = false;
                bol_div = false;
                bol_porc = false;
                cajaTexto.setText(acumulat);
            }
        };
        boton1.addActionListener(oyente13);
        panel.add(boton1);

        JButton boton2 = new JButton();
        boton2.setText("⬅"); // Text del boto
        boton2.setBounds(50, 75, 55, 55);
        boton2.setHorizontalAlignment(SwingConstants.CENTER);
        boton2.setEnabled(true); // Boto ON o OFF
        boton2.setBackground(Color.darkGray);
        //boton2.setMnemonic('a');
        boton2.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajaTexto.setText(cajaTexto.getText().substring(0, cajaTexto.getText().length()-1));
                acumulat = cajaTexto.getText();
            }
        };
        boton2.addActionListener(oyente10);
        panel.add(boton2);

        JButton boton3 = new JButton();
        boton3.setText("%"); // Text del boto
        boton3.setBounds(100, 75, 55, 55);
        boton3.setHorizontalAlignment(SwingConstants.CENTER);
        boton3.setEnabled(true); // Boto ON o OFF
        boton3.setBackground(Color.darkGray);
        //boton3.setMnemonic('a');
        boton3.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto
        ActionListener porc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre1 = Double.parseDouble(cajaTexto.getText());
                cajaTexto.setText(null);
                operacio = "%";
                acumulat = "";
            }
        };
        boton3.addActionListener(porc);
        panel.add(boton3);

        JButton boton4 = new JButton();
        boton4.setText("/"); // Text del boto
        boton4.setBounds(150, 75, 55, 55);
        boton4.setHorizontalAlignment(SwingConstants.CENTER);
        boton4.setEnabled(true); // Boto ON o OFF
        boton4.setBackground(Color.darkGray);
        //boton4.setMnemonic('a');
        boton4.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto
        ActionListener div = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre1 = Double.parseDouble(cajaTexto.getText());
                cajaTexto.setText(null);
                operacio = "/";
                acumulat = "";
            }
        };
        boton4.addActionListener(div);
        panel.add(boton4);

        JButton boton5 = new JButton();
        boton5.setText("7"); // Text del boto
        boton5.setBounds(0, 125, 55, 55);
        boton5.setHorizontalAlignment(SwingConstants.CENTER);
        boton5.setEnabled(true); // Boto ON o OFF
        boton5.setBackground(Color.darkGray);
        //boton5.setMnemonic('a');
        boton5.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente12= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton5);
            }
        };
        boton5.addActionListener(oyente12);
        panel.add(boton5);

        JButton boton6 = new JButton();
        boton6.setText("8"); // Text del boto
        boton6.setBounds(50, 125, 55, 55);
        boton6.setHorizontalAlignment(SwingConstants.CENTER);
        boton6.setEnabled(true); // Boto ON o OFF
        boton6.setBackground(Color.darkGray);
        //boton6.setMnemonic('a');
        boton6.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton6);
            }
        };
        boton6.addActionListener(oyente);
        panel.add(boton6);

        JButton boton7 = new JButton();
        boton7.setText("9"); // Text del boto
        boton7.setBounds(100, 125, 55, 55);
        boton7.setHorizontalAlignment(SwingConstants.CENTER);
        boton7.setEnabled(true); // Boto ON o OFF
        boton7.setBackground(Color.darkGray);
        //boton7.setMnemonic('a');
        boton7.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente2= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton7);
            }
        };
        boton7.addActionListener(oyente2);
        panel.add(boton7);

        JButton boton8 = new JButton();
        boton8.setText("x"); // Text del boto
        boton8.setBounds(150, 125, 55, 55);
        boton8.setHorizontalAlignment(SwingConstants.CENTER);
        boton8.setEnabled(true); // Boto ON o OFF
        boton8.setBackground(Color.darkGray);
        //boton8.setMnemonic('a');
        boton8.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto
        ActionListener multi = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre1 = Double.parseDouble(cajaTexto.getText());
                cajaTexto.setText(null);
                operacio = "x";
                acumulat = "";
            }
        };
        boton8.addActionListener(multi);
        panel.add(boton8);

        JButton boton9 = new JButton();
        boton9.setText("4"); // Text del boto
        boton9.setBounds(0, 175, 55, 55);
        boton9.setHorizontalAlignment(SwingConstants.CENTER);
        boton9.setEnabled(true); // Boto ON o OFF
        boton9.setBackground(Color.darkGray);
        //boton9.setMnemonic('a');
        boton9.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente3= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton9);
            }
        };
        boton9.addActionListener(oyente3);
        panel.add(boton9);

        JButton boton10 = new JButton();
        boton10.setText("5"); // Text del boto
        boton10.setBounds(50, 175, 55, 55);
        boton10.setHorizontalAlignment(SwingConstants.CENTER);
        boton10.setEnabled(true); // Boto ON o OFF
        boton10.setBackground(Color.darkGray);
        //boton10.setMnemonic('a');
        boton10.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente4= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton10);
            }
        };
        boton10.addActionListener(oyente4);
        panel.add(boton10);

        JButton boton11 = new JButton();
        boton11.setText("6"); // Text del boto
        boton11.setBounds(100, 175, 55, 55);
        boton11.setHorizontalAlignment(SwingConstants.CENTER);
        boton11.setEnabled(true); // Boto ON o OFF
        boton11.setBackground(Color.darkGray);
        //boton11.setMnemonic('a');
        boton11.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente5= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton11);
            }
        };
        boton11.addActionListener(oyente5);
        panel.add(boton11);

        JButton boton12 = new JButton();
        boton12.setText("-"); // Text del boto
        boton12.setBounds(150, 175, 55, 55);
        boton12.setHorizontalAlignment(SwingConstants.CENTER);
        boton12.setEnabled(true); // Boto ON o OFF
        boton12.setBackground(Color.darkGray);
        //boton12.setMnemonic('a');
        boton12.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener restar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre1 = Double.parseDouble(cajaTexto.getText());
                cajaTexto.setText(null);
                operacio = "-";
                acumulat = "";
            }
        };
        boton12.addActionListener(restar);
        panel.add(boton12);

        JButton boton13 = new JButton();
        boton13.setText("1"); // Text del boto
        boton13.setBounds(0, 225, 55, 55);
        boton13.setHorizontalAlignment(SwingConstants.CENTER);
        boton13.setEnabled(true); // Boto ON o OFF
        boton13.setBackground(Color.darkGray);
        //boton13.setMnemonic('a');
        boton13.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyentetexto3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton13);
            }
        };
        boton13.addActionListener(oyentetexto3);
        panel.add(boton13);

        JButton boton14 = new JButton();
        boton14.setText("2"); // Text del boto
        boton14.setBounds(50, 225, 55, 55);
        boton14.setHorizontalAlignment(SwingConstants.CENTER);
        boton14.setEnabled(true); // Boto ON o OFF
        boton14.setBackground(Color.darkGray);
        //boton14.setMnemonic('a');
        boton14.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyentetexto1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton14);
            }
        };
        boton14.addActionListener(oyentetexto1);
        panel.add(boton14);

        JButton boton15 = new JButton();
        boton15.setText("3"); // Text del boto
        boton15.setBounds(100, 225, 55, 55);
        boton15.setHorizontalAlignment(SwingConstants.CENTER);
        boton15.setEnabled(true); // Boto ON o OFF
        boton15.setBackground(Color.darkGray);
        //boton15.setMnemonic('a');
        boton15.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton15);
            }
        };
        boton15.addActionListener(oyente8);
        panel.add(boton15);

        JButton boton16 = new JButton();
        boton16.setText("+"); // Text del boto
        boton16.setBounds(150, 225, 55, 55);
        boton16.setHorizontalAlignment(SwingConstants.CENTER);
        boton16.setEnabled(true); // Boto ON o OFF
        boton16.setBackground(Color.darkGray);
        //boton16.setMnemonic('a');
        boton16.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener sumar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre1 = Double.parseDouble(cajaTexto.getText());
                cajaTexto.setText(null);
                operacio = "+";
                acumulat = "";
            }
        };
        boton16.addActionListener(sumar);
        panel.add(boton16);

        JButton boton17 = new JButton();
        boton17.setText("0"); // Text del boto
        boton17.setBounds(0, 275, 105, 55);
        boton17.setHorizontalAlignment(SwingConstants.CENTER);
        boton17.setEnabled(true); // Boto ON o OFF
        boton17.setBackground(Color.darkGray);
        //boton17.setMnemonic('a');
        boton17.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener oyente9= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignarValors(boton17);
            }
        };
        boton17.addActionListener(oyente9);
        panel.add(boton17);

        JButton boton18 = new JButton();
        boton18.setText("."); // Text del boto
        boton18.setBounds(100, 275, 55, 55);
        boton18.setHorizontalAlignment(SwingConstants.CENTER);
        boton18.setEnabled(true); // Boto ON o OFF
        boton18.setBackground(Color.darkGray);
        boton18.setBorderPainted(true);
        //boton18.setMnemonic('a');
        boton18.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener coma= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajaTexto.setText(acumulat + ".");
                acumulat = cajaTexto.getText();
            }
        };
        boton18.addActionListener(coma);
        panel.add(boton18);

        JButton boton19 = new JButton();
        boton19.setText("="); // Text del boto
        boton19.setBounds(150, 275, 55, 55);
        boton19.setHorizontalAlignment(SwingConstants.CENTER);
        boton19.setEnabled(true); // Boto ON o OFF
        boton19.setBackground(Color.darkGray);
        //boton19.setMnemonic('a');
        boton19.setFont(new Font("arial", 1, 15)); //Establim font de la lletra del boto

        ActionListener igual = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nombre2 = Double.parseDouble(cajaTexto.getText());
                if (operacio.equals("+")){
                    if (!bol_suma){
                        resultat = nombre1 + nombre2;
                        bol_suma = true;
                        acumulat = String.valueOf(resultat);
                    }
                    else {
                        resultat = resultat + nombre2;
                        acumulat = String.valueOf(resultat);
                    }
                }

                else if (operacio.equals("-")) {
                    if (!bol_resta) {
                        resultat = nombre1 - nombre2;
                        bol_resta = true;
                        acumulat = String.valueOf(resultat);
                    } else {
                        resultat = resultat - nombre2;
                        acumulat = String.valueOf(resultat);
                    }
                }
                else if(operacio.equals("x")) {
                    if (!bol_multi) {
                        resultat = nombre1 * nombre2;
                        bol_multi = true;
                        acumulat = String.valueOf(resultat);
                    } else{
                        resultat = resultat * nombre2;
                        acumulat = String.valueOf(resultat);
                    }
                }
                else if (operacio.equals("/")) {
                    if (!bol_div) {
                        resultat = nombre1 / nombre2;
                        acumulat = String.valueOf(resultat);
                        bol_div = true;

                    } else {
                        resultat = resultat / nombre2;
                        acumulat = String.valueOf(resultat);
                    }
                }
                else if (operacio.equals("%")) {
                    if (!bol_porc) {
                        resultat = nombre1 % nombre2;
                        acumulat = String.valueOf(resultat);
                        bol_porc = true;

                    } else {
                        resultat = resultat % nombre2;
                        acumulat = String.valueOf(resultat);
                    }
                }


                resultatfinal = Double.toString(resultat);
                cajaTexto.setText(resultatfinal);
                acumulat = resultatfinal;

            }
        };
        boton19.addActionListener(igual);
        panel.add(boton19);
    }


    private void colocarCajasDeTexto() {
        cajaTexto.setBounds(0, 0, 205, 80);
        cajaTexto.setText("0");
        cajaTexto.setFont(new Font("San Francisco", 0, 40));
        cajaTexto.setEditable(true);
        cajaTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        cajaTexto.setBackground(Color.darkGray);

        panel.add(cajaTexto);

    }

    private void controlNumeros(){
        cajaTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                cajaTexto.setEditable(false);

                //millora --> bug
                /*String value = cajaTexto.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    cajaTexto.setEditable(true);
                    String valorsactuals = cajaTexto.getText().substring(0, cajaTexto.getText().length()-1);
                    System.out.println("valors actual "+ valorsactuals);
                    acumulat = acumulat + valorsactuals;
                    System.out.println("acumulat " + acumulat);
                } else if (ke.getKeyChar() == '.') {
                    cajaTexto.setEditable(true);
                } else if (ke.getKeyCode() == 8) {
                    cajaTexto.setEditable(true);
                } else {
                    cajaTexto.setEditable(false);
                }*/
            }
        });

    }


    public void assignarValors(JButton a){
        String valor = a.getText();
        if (acumulat.length() == 1 && cajaTexto.getText().equals("0")) {
            acumulat = valor;
            cajaTexto.setText(acumulat);
        }
        else {
            acumulat = acumulat + valor;
            cajaTexto.setText(acumulat);
        }

    }
}

