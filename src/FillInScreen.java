
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

/*
 * Created By Syariffudin Sapri
 * syariffudin.sapri@baesystems.com 
 * syariffudinsapri@gmail.com
 */

/**
 *
 * @author Syariffudin <syariffudinsapri@gmail.com>
 */
public class FillInScreen extends javax.swing.JFrame {

    final String VERSION = "1.30";
    final String SCREEN_TITLE = "Discripter: JIRA Description Generator v"+VERSION+" - Syariffudin";
    final String DATE = "September 2015";
    final String currentChanges = 
            VERSION+" - Better flow and small fix applied\n";
    final String versionHistory = ""+
            "1.22 - Bug Killing (let me know if there's bugs still alive)\n"+
            "1.21 - Improved Copy To Clipboard Screen\n" +
            "1.20 - Added Guide Screen & some bug killing\n"+
            "1.10 - Changes on UI and Input Options\n"+
            "1.00 - Descripter was born";
    String tempWholeText;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int xLocation,yLocation;
    DefaultCaret caret;
    
    JFrame frameCopyScreen,frameGuideScreen;
    
    Point currentMainScreenPosition;
    
    
    /**
     * Creates new form MainScreen
     */
    public FillInScreen() {
        initComponents();
        xLocation = dim.width/2-this.getSize().width/2;
        yLocation=dim.height/2-this.getSize().height/2;
        this.setLocation(xLocation, yLocation);
        this.setResizable(false);
        this.pack();
        //checkMadotary();
    }
    
    /**
     * get all the field text and compiled to certain format
     * @return String
     */
    public String getCompiledText(){
        String doc,brief,url="",browser="",role,temp,
                screencap,screencap2,screename,roleuser,rolepass,
                actResult,expectResult,steps;
        doc =docTextBox.getText() + " Page number: "+ pageTextBox.getText() + " at "+ atTextBox.getText();
        brief = briefTextBox.getText();
        if(!urlLocationTextBox.getText().isEmpty())
            url="\nURL/Location: " + urlLocationTextBox.getText();
        if(!browserVersionTextBox.getText().isEmpty())
            browser="\nBrowser: "+browserList.getSelectedValue().toString() + " version: "+ browserVersionTextBox.getText();
        roleuser=usernameTextBox.getText();
        rolepass=passwordTextBox.getText();
        if(roleuser.isEmpty() | rolepass.isEmpty())
            role="\nRole: "+roleTextBox.getText();
        else
            role="\nRole: "+roleTextBox.getText() + " (Login using username: "+ roleuser +" | password: "+ rolepass+")";
        if(screencaptureTextBox.getText().isEmpty()){
            screencap="";
            screencap2="";
        }
        else {
            screencap="\nScreen capture: " + screencaptureTextBox.getText();
            screencap2=", refer to screen capture "+ screencaptureTextBox.getText();
        }
        
        if(screenNameTextBox.getText().isEmpty())
            screename="";
        else
            screename="\nScreen name: "+screenNameTextBox.getText();
        
        if(!stepsTextBox.getText().isEmpty())
            steps="\n\n---- Steps ----\n"+stepsTextBox.getText();
        else
            steps="";
        
        actResult=actualResultTextBox.getText();
        expectResult=expectedTextBox.getText(); 
        
        temp = "---- Description ----\n"+ 
                brief + ", it is not according to document: " + doc + screencap2 + "\n\n" +
                "---- Actual Results ----\n" + actResult + "\n\n" +
                "---- Expected Results ----\n" + expectResult + "\n\n" +
                "---- Other Info ----" +
                "\nDocument Name: "+doc +
                url + 
                browser + 
                role +
                screencap +
                screename +
                steps;
        return temp; 
    }
    
    /**
     * check all the maditory field, return field which are empty/not filled
     * @return String
     */
    public String checkTextBoxMaditory(){
        if(docTextBox.getText().isEmpty())
            return "Document field is empty";
        if(pageTextBox.getText().isEmpty())
            return "Page number field is empty";
        if(atTextBox.getText().isEmpty())
            return "Location in document (At textbox) field is empty";
        if(briefTextBox.getText().isEmpty())
            return "Brief field is empty";
        /*if(urlLocationTextBox.getText().isEmpty())
            return "URL location field is empty";*/
//        if(browserList.isSelectionEmpty() || browserList.getSelectedValue().equals("Pick"))
//            return "please select your Browser type";
//        if(browserVersionTextBox.getText().isEmpty())
//            return "your browser version field is empty";
        if(roleTextBox.getText().isEmpty())
            return "your Role field is empty";
        if(actualResultTextBox.getText().isEmpty())
            return "Actual Result field  is is empty";
        if(expectedTextBox.getText().isEmpty())
            return "Expected Result field is empty";
        else
            return "pass";
    }
    
    /**
     * to initialize copyscreen
     */
    public void initCopyScreen(){
        frameCopyScreen = new JFrame();
        frameCopyScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCopyScreen.setLocation(currentMainScreenPosition);
        frameCopyScreen.setTitle("Compiled Description");
        frameCopyScreen.setResizable(false);
        frameCopyScreen.add(new CopyScreen(getCompiledText(),this));
        frameCopyScreen.pack();
        frameCopyScreen.setVisible(true);
            
    }
    
    /**
     * to initialize HelpPicture
     */
    public void initHelpScreen(){
        frameGuideScreen = new JFrame();
        frameGuideScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameGuideScreen.setLocation(currentMainScreenPosition);
        frameGuideScreen.setTitle("Help Screen");
        //frame.setSize(758,670);
        frameGuideScreen.setResizable(false);
        frameGuideScreen.add(new GuideScreen());
        frameGuideScreen.pack();
        frameGuideScreen.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        actualResultTextBox = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        expectedTextBox = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pageTextBox = new javax.swing.JTextField();
        atTextBox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        browserVersionTextBox = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        browserList = new javax.swing.JList();
        jScrollPane10 = new javax.swing.JScrollPane();
        screenNameTextBox = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        usernameTextBox = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        passwordTextBox = new javax.swing.JTextPane();
        clearScreenCaptureButton = new javax.swing.JButton();
        clearActualButton = new javax.swing.JButton();
        clearExpectedButton = new javax.swing.JButton();
        clearDocButton = new javax.swing.JButton();
        clearPageandAtButton = new javax.swing.JButton();
        clearBriefButton = new javax.swing.JButton();
        clearRoleButton = new javax.swing.JButton();
        clearBrowserButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        generateDescriptionBUtton = new javax.swing.JButton();
        clearALLButton = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        stepsTextBox = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        clearStepsButton = new javax.swing.JButton();
        docTextBox = new javax.swing.JTextField();
        briefTextBox = new javax.swing.JTextField();
        urlLocationTextBox = new javax.swing.JTextField();
        roleTextBox = new javax.swing.JTextField();
        screencaptureTextBox = new javax.swing.JTextField();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(SCREEN_TITLE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(537, 844));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Generate Description For JIRA");

        actualResultTextBox.setColumns(20);
        actualResultTextBox.setRows(5);
        actualResultTextBox.setToolTipText("The actual results that shows during the test");
        jScrollPane1.setViewportView(actualResultTextBox);

        jLabel1.setText("Document Name*");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setText("Role*");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("Actual Results*");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        expectedTextBox.setColumns(20);
        expectedTextBox.setRows(5);
        expectedTextBox.setToolTipText("The expected results that suppose to happen, usually refers to document");
        jScrollPane4.setViewportView(expectedTextBox);

        jLabel5.setText("Expected Results*");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setText("Screen Capture");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setText("At*:");

        jLabel8.setText("Page*:");

        pageTextBox.setToolTipText("The Page number to be refer to");
        pageTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageTextBoxActionPerformed(evt);
            }
        });

        atTextBox.setToolTipText("Can be section/table/point ect");
        atTextBox.setAutoscrolls(false);
        atTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atTextBoxActionPerformed(evt);
            }
        });

        jLabel9.setText("URL/Location");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setText("Browser & Version");

        browserVersionTextBox.setToolTipText("Version of the browser");
        jScrollPane7.setViewportView(browserVersionTextBox);

        jLabel11.setText("Title Summary*");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        browserList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Pick", "IE", "Chrome", "Firefox", "Opera" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        browserList.setToolTipText("Click the selection to select");
        browserList.setMaximumSize(new java.awt.Dimension(45, 80));
        browserList.setPreferredSize(new java.awt.Dimension(45, 80));
        jScrollPane9.setViewportView(browserList);

        screenNameTextBox.setUI(new HintTextFieldUI("Screen Name"));
        screenNameTextBox.setToolTipText("Screen Name(Optional)");
        jScrollPane10.setViewportView(screenNameTextBox);

        usernameTextBox.setUI(new HintTextFieldUI("Username"));
        usernameTextBox.setToolTipText("Username to login to system");
        jScrollPane11.setViewportView(usernameTextBox);

        passwordTextBox.setUI(new HintTextFieldUI("Password"));
        passwordTextBox.setToolTipText("Password used to login to system");
        jScrollPane12.setViewportView(passwordTextBox);

        clearScreenCaptureButton.setText("Clear");
        clearScreenCaptureButton.setToolTipText("Clear Screen Capture and Name Field");
        clearScreenCaptureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearScreenCaptureButtonActionPerformed(evt);
            }
        });

        clearActualButton.setText("Clear");
        clearActualButton.setToolTipText("Clear Actual Result Field");
        clearActualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActualButtonActionPerformed(evt);
            }
        });

        clearExpectedButton.setText("Clear");
        clearExpectedButton.setToolTipText("Clear Expected Result Field");
        clearExpectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearExpectedButtonActionPerformed(evt);
            }
        });

        clearDocButton.setText("Clear");
        clearDocButton.setToolTipText("Clear Document Name Field");
        clearDocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDocButtonActionPerformed(evt);
            }
        });

        clearPageandAtButton.setText("Clear");
        clearPageandAtButton.setToolTipText("Clear Page and At Field");
        clearPageandAtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPageandAtButtonActionPerformed(evt);
            }
        });

        clearBriefButton.setText("Clear");
        clearBriefButton.setToolTipText("Clear Brief Field");
        clearBriefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBriefButtonActionPerformed(evt);
            }
        });

        clearRoleButton.setText("Clear");
        clearRoleButton.setToolTipText("Clear Role, Username, Password Field");
        clearRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearRoleButtonActionPerformed(evt);
            }
        });

        clearBrowserButton.setText("Clear");
        clearBrowserButton.setToolTipText("Clear Browser Selection and Version Field");
        clearBrowserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBrowserButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Monotype Corsiva", 0, 11)); // NOI18N
        jButton1.setText("  i  ");
        jButton1.setToolTipText("Information");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        generateDescriptionBUtton.setText("Generate");
        generateDescriptionBUtton.setToolTipText("Generate Description");
        generateDescriptionBUtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateDescriptionBUttonActionPerformed(evt);
            }
        });

        clearALLButton.setText("Clear All");
        clearALLButton.setToolTipText("Clear All Field");
        clearALLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearALLButtonActionPerformed(evt);
            }
        });

        stepsTextBox.setColumns(20);
        stepsTextBox.setRows(5);
        stepsTextBox.setToolTipText("The expected results that suppose to happen, usually refers to document");
        jScrollPane13.setViewportView(stepsTextBox);

        jLabel12.setText("Steps");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        clearStepsButton.setText("Clear");
        clearStepsButton.setToolTipText("Clear Expected Result Field");
        clearStepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStepsButtonActionPerformed(evt);
            }
        });

        docTextBox.setToolTipText("Document name to be refer to");
        docTextBox.setAutoscrolls(false);
        docTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docTextBoxActionPerformed(evt);
            }
        });

        briefTextBox.setToolTipText("Summary of the description");
        briefTextBox.setAutoscrolls(false);
        briefTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                briefTextBoxActionPerformed(evt);
            }
        });

        urlLocationTextBox.setToolTipText("URL/Location of the Application/Web");
        urlLocationTextBox.setAutoscrolls(false);
        urlLocationTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlLocationTextBoxActionPerformed(evt);
            }
        });

        roleTextBox.setToolTipText("Type of Role");
        roleTextBox.setAutoscrolls(false);
        roleTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleTextBoxActionPerformed(evt);
            }
        });

        screencaptureTextBox.setToolTipText("Screen capture file name with extension (eg  thisscreen.jpeg)");
        screencaptureTextBox.setAutoscrolls(false);
        screencaptureTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screencaptureTextBoxActionPerformed(evt);
            }
        });

        helpButton.setFont(new java.awt.Font("Monotype Corsiva", 0, 11)); // NOI18N
        helpButton.setText("  Guide   ");
        helpButton.setToolTipText("Help");
        helpButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(screencaptureTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(roleTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane9)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(urlLocationTextBox)
                                            .addComponent(briefTextBox, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(docTextBox))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pageTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(atTextBox)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clearScreenCaptureButton)
                                    .addComponent(clearActualButton)
                                    .addComponent(clearPageandAtButton)
                                    .addComponent(clearBriefButton)
                                    .addComponent(clearRoleButton)
                                    .addComponent(clearBrowserButton)
                                    .addComponent(clearStepsButton)
                                    .addComponent(clearDocButton))
                                .addContainerGap(19, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(helpButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearExpectedButton)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(generateDescriptionBUtton, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearALLButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clearActualButton, clearBriefButton, clearBrowserButton, clearDocButton, clearExpectedButton, clearPageandAtButton, clearRoleButton, clearScreenCaptureButton, clearStepsButton});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane13, jScrollPane4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(helpButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(docTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearDocButton))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(atTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearPageandAtButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pageTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearBriefButton)
                            .addComponent(briefTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(urlLocationTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBrowserButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addGap(1, 1, 1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearRoleButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(roleTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel4)
                                        .addGap(88, 88, 88)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(screencaptureTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generateDescriptionBUtton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearALLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clearScreenCaptureButton)
                        .addGap(45, 45, 45)
                        .addComponent(clearActualButton)
                        .addGap(75, 75, 75)
                        .addComponent(clearExpectedButton)
                        .addGap(80, 80, 80)
                        .addComponent(clearStepsButton)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clearActualButton, clearBriefButton, clearBrowserButton, clearDocButton, clearExpectedButton, clearPageandAtButton, clearRoleButton, clearScreenCaptureButton, clearStepsButton});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {briefTextBox, docTextBox, urlLocationTextBox});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane13, jScrollPane4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {atTextBox, pageTextBox});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane10, jScrollPane11, jScrollPane12, jScrollPane7, roleTextBox, screencaptureTextBox});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clearALLButton, generateDescriptionBUtton});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, 643, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void screencaptureTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screencaptureTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_screencaptureTextBoxActionPerformed

    private void roleTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleTextBoxActionPerformed

    private void urlLocationTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlLocationTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urlLocationTextBoxActionPerformed

    private void briefTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_briefTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_briefTextBoxActionPerformed

    private void docTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docTextBoxActionPerformed

    private void clearStepsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStepsButtonActionPerformed
        // TODO add your handling code here:
        stepsTextBox.setText("");
    }//GEN-LAST:event_clearStepsButtonActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void clearALLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearALLButtonActionPerformed
        // TODO add your handling code here:
        docTextBox.setText("");
        pageTextBox.setText("");
        atTextBox.setText("");
        briefTextBox.setText("");
        browserVersionTextBox.setText("");
        browserList.clearSelection();
        roleTextBox.setText("");
        passwordTextBox.setText("");
        usernameTextBox.setText("");
        screenNameTextBox.setText("");
        screencaptureTextBox.setText("");
        actualResultTextBox.setText("");
        expectedTextBox.setText("");
        urlLocationTextBox.setText("");
        stepsTextBox.setText("");
    }//GEN-LAST:event_clearALLButtonActionPerformed

    private void generateDescriptionBUttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateDescriptionBUttonActionPerformed
        // TODO add your handling code here:
        if(checkTextBoxMaditory().equals("pass") && frameCopyScreen==null){
            initCopyScreen();
        }
        else if(frameCopyScreen!=null && checkTextBoxMaditory().equalsIgnoreCase("pass")){
            frameCopyScreen.dispose();
            frameCopyScreen=null;
        }
        else
            JOptionPane.showMessageDialog(this,checkTextBoxMaditory(),"Warning!",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_generateDescriptionBUttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Developed by: Syariffudin Sapri (syariffudinsapri@gmail.com)\n"
            + "Version: "+
                VERSION +
             "\nDate: "+DATE +
                "\n\n"+
                "-- Current Version --\n"+
                currentChanges+
                "\n-- Version History --\n"+
                versionHistory,
            "Descripter Information",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearBrowserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBrowserButtonActionPerformed
        // TODO add your handling code here:
        browserVersionTextBox.setText("");
        browserList.clearSelection();
    }//GEN-LAST:event_clearBrowserButtonActionPerformed

    private void clearRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearRoleButtonActionPerformed
        // TODO add your handling code here:
        roleTextBox.setText("");
        passwordTextBox.setText("");
        usernameTextBox.setText("");
    }//GEN-LAST:event_clearRoleButtonActionPerformed

    private void clearBriefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBriefButtonActionPerformed
        // TODO add your handling code here:
        briefTextBox.setText("");
    }//GEN-LAST:event_clearBriefButtonActionPerformed

    private void clearPageandAtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearPageandAtButtonActionPerformed
        // TODO add your handling code here:
        pageTextBox.setText("");
        atTextBox.setText("");
    }//GEN-LAST:event_clearPageandAtButtonActionPerformed

    private void clearDocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDocButtonActionPerformed
        // TODO add your handling code here:
        docTextBox.setText("");
    }//GEN-LAST:event_clearDocButtonActionPerformed

    private void clearExpectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearExpectedButtonActionPerformed
        // TODO add your handling code here:
        expectedTextBox.setText("");
    }//GEN-LAST:event_clearExpectedButtonActionPerformed

    private void clearActualButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActualButtonActionPerformed
        // TODO add your handling code here:
        actualResultTextBox.setText("");
    }//GEN-LAST:event_clearActualButtonActionPerformed

    private void clearScreenCaptureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearScreenCaptureButtonActionPerformed
        // TODO add your handling code here:
        screencaptureTextBox.setText("");
        screenNameTextBox.setText("");
    }//GEN-LAST:event_clearScreenCaptureButtonActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        if(!briefTextBox.getText().isEmpty() & briefTextBox.getText().length()>=45)
        JOptionPane.showMessageDialog(null,briefTextBox.getText(),
            "Brief Field Info",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        if(!urlLocationTextBox.getText().isEmpty() & urlLocationTextBox.getText().length()>=45)
        JOptionPane.showMessageDialog(null,urlLocationTextBox.getText(),
            "URL/Location Field Info",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void atTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atTextBoxActionPerformed

    private void pageTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pageTextBoxActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        if(!screencaptureTextBox.getText().isEmpty() & screencaptureTextBox.getText().length()>=22)
        JOptionPane.showMessageDialog(null,screencaptureTextBox.getText(),
            "Screen Capture Field Info",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        String temp;
        if(!expectedTextBox.getText().isEmpty() & expectedTextBox.getText().length()>=200){
            temp=new StringBuilder(expectedTextBox.getText()).insert(expectedTextBox.getText().length()/4, "-\n").toString();
            temp=new StringBuilder(temp).insert(temp.length()/2, "-\n").toString();
            JOptionPane.showMessageDialog(null,temp,
                "Expected Results Field Info",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        String temp;
        if(!actualResultTextBox.getText().isEmpty() & actualResultTextBox.getText().length()>=200){
            temp=new StringBuilder(actualResultTextBox.getText()).insert(
                actualResultTextBox.getText().length()/4, "-\n").toString();
            temp=new StringBuilder(temp).insert(temp.length()/2, "-\n").toString();
            JOptionPane.showMessageDialog(null,temp,
                "Actual Results Field Info",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        if(!roleTextBox.getText().isEmpty() & roleTextBox.getText().length()>=10)
        JOptionPane.showMessageDialog(null,roleTextBox.getText(),
            "Role Field Info",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        if(!docTextBox.getText().isEmpty() & docTextBox.getText().length()>=45)
        JOptionPane.showMessageDialog(null,docTextBox.getText(),
            "Document Field Info",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // TODO add your handling code here:
        initHelpScreen();
    }//GEN-LAST:event_helpButtonActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        // TODO add your handling code here:
        currentMainScreenPosition = this.getLocation();
    }//GEN-LAST:event_formComponentMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FillInScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FillInScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea actualResultTextBox;
    private javax.swing.JTextField atTextBox;
    private javax.swing.JTextField briefTextBox;
    private javax.swing.JList browserList;
    private javax.swing.JTextPane browserVersionTextBox;
    private javax.swing.JButton clearALLButton;
    private javax.swing.JButton clearActualButton;
    private javax.swing.JButton clearBriefButton;
    private javax.swing.JButton clearBrowserButton;
    private javax.swing.JButton clearDocButton;
    private javax.swing.JButton clearExpectedButton;
    private javax.swing.JButton clearPageandAtButton;
    private javax.swing.JButton clearRoleButton;
    private javax.swing.JButton clearScreenCaptureButton;
    private javax.swing.JButton clearStepsButton;
    private javax.swing.JTextField docTextBox;
    private javax.swing.JTextArea expectedTextBox;
    private javax.swing.JButton generateDescriptionBUtton;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField pageTextBox;
    private javax.swing.JTextPane passwordTextBox;
    private javax.swing.JTextField roleTextBox;
    private javax.swing.JTextPane screenNameTextBox;
    private javax.swing.JTextField screencaptureTextBox;
    private javax.swing.JTextArea stepsTextBox;
    private javax.swing.JTextField urlLocationTextBox;
    private javax.swing.JTextPane usernameTextBox;
    // End of variables declaration//GEN-END:variables
}
