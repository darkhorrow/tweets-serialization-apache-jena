package serialize.tweets.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;

public class AppWindow extends javax.swing.JFrame {

    private final TweetConversor conversor;

    public AppWindow(TweetConversor conversor) {
        this.conversor = conversor;
        initComponents();

        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(1, new JLabel("1"));
        labels.put(50, new JLabel("50"));
        labels.put(100, new JLabel("100"));
        labels.put(150, new JLabel("150"));
        labels.put(200, new JLabel("200"));
        tweetsAmountSlider.setLabelTable(labels);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formatGroupButton = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tweetsAmountSlider = new javax.swing.JSlider();
        tweetsAmountLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        outputPathField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        outputButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        radioButtonXML = new javax.swing.JRadioButton();
        turtleRadioButton = new javax.swing.JRadioButton();
        submitButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        classField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tweets Serializator");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tweets Serializator");

        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchFieldCaretUpdate(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nº of tweets"));

        tweetsAmountSlider.setMajorTickSpacing(199);
        tweetsAmountSlider.setMaximum(200);
        tweetsAmountSlider.setMinimum(1);
        tweetsAmountSlider.setMinorTickSpacing(50);
        tweetsAmountSlider.setPaintLabels(true);
        tweetsAmountSlider.setPaintTicks(true);
        tweetsAmountSlider.setValue(1);
        tweetsAmountSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tweetsAmountSliderStateChanged(evt);
            }
        });

        tweetsAmountLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tweetsAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tweetsAmountLabel.setText("1");
        tweetsAmountLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tweetsAmountSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(tweetsAmountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(tweetsAmountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweetsAmountSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        outputPathField.setEditable(false);

        jLabel2.setText("Path of the file:");

        outputButton.setText("Save in...");
        outputButton.setPreferredSize(new java.awt.Dimension(79, 20));
        outputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Format:");

        formatGroupButton.add(radioButtonXML);
        radioButtonXML.setSelected(true);
        radioButtonXML.setText("RDFXML");

        formatGroupButton.add(turtleRadioButton);
        turtleRadioButton.setText("Turtle");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(outputPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(radioButtonXML, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(turtleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputPathField)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(outputButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioButtonXML)
                        .addComponent(turtleRadioButton)))
                .addContainerGap())
        );

        submitButton.setText("Serialize tweets");
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Search:");

        jLabel5.setText("Topic/subject of the search:");

        classField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        classField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                classFieldCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchField)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(classField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tweetsAmountSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tweetsAmountSliderStateChanged
        Integer tweetsAmount = tweetsAmountSlider.getValue();
        tweetsAmountLabel.setText(tweetsAmount.toString());
        submitButtonCheck();
    }//GEN-LAST:event_tweetsAmountSliderStateChanged

    private void outputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            outputPathField.setText(fc.getSelectedFile().getAbsolutePath());
        }
        submitButtonCheck();
    }//GEN-LAST:event_outputButtonActionPerformed

    private void searchFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchFieldCaretUpdate
        submitButtonCheck();
    }//GEN-LAST:event_searchFieldCaretUpdate

    private void classFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_classFieldCaretUpdate
        submitButtonCheck();
    }//GEN-LAST:event_classFieldCaretUpdate

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        submitButton.setText("Serializing...");
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                saveRDFModel();
                submitButton.setText("Serialize tweets");
                return null;
            }
        };
        worker.execute();     
    }//GEN-LAST:event_submitButtonActionPerformed

    private void submitButtonCheck() {
        if(tweetsAmountSlider.getValue() > 0
                && !outputPathField.getText().equals("")
                && !searchField.getText().equals("")
                && !classField.getText().equals("")) {
            submitButton.setEnabled(true);
        } else {
            submitButton.setEnabled(false);
        }
    }
    
    private void saveRDFModel() {
        OutputStream outStream = null;
        try {
            int tweetsAmount = tweetsAmountSlider.getValue();
            String query = searchField.getText();
            String topic = classField.getText();
            Enumeration<AbstractButton> buttons = formatGroupButton.getElements();
            RDFFormat outputFormat = RDFFormat.RDFXML_PRETTY;
            String outputExtension = ".rdf";

            while(buttons.hasMoreElements()) {
                AbstractButton button = buttons.nextElement();
                if(button.isSelected()) {
                    switch(button.getText().toLowerCase()) {
                        case "rdfxml":
                        outputFormat = RDFFormat.RDFXML_PRETTY;
                        outputExtension = ".rdf";
                        break;
                        case "turtle":
                        outputFormat = RDFFormat.TURTLE_PRETTY;
                        outputExtension = ".ttl";
                        break;
                        default:
                        break;
                    }
                    break;
                }
            }

            if(outputPathField.getText().endsWith(outputExtension)){
                outStream = new FileOutputStream(outputPathField.getText());
            } else {
                outStream = new FileOutputStream(outputPathField.getText() +
                    outputExtension);
            }

            
            Model model = conversor.toRDF(query, topic, tweetsAmount);
            RDFDataMgr.write(outStream, model, outputFormat);
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn´t create the file: " + ex);
            JOptionPane.showMessageDialog(null, "Cannot create the output file."
                    + " Check the permissions of the directory.");
        } finally {
            try {
                if(outStream != null) {
                    outStream.close();
                }
            } catch(IOException ex) {
                System.out.println("OutputStream error: " + ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField classField;
    private javax.swing.ButtonGroup formatGroupButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton outputButton;
    private javax.swing.JTextField outputPathField;
    private javax.swing.JRadioButton radioButtonXML;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton submitButton;
    private javax.swing.JRadioButton turtleRadioButton;
    private javax.swing.JLabel tweetsAmountLabel;
    private javax.swing.JSlider tweetsAmountSlider;
    // End of variables declaration//GEN-END:variables
}
