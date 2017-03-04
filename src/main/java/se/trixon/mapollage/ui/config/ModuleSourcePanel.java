/*
 * Copyright 2017 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.mapollage.ui.config;

import java.awt.event.FocusAdapter;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.commons.lang3.StringUtils;
import se.trixon.almond.util.Dict;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.almond.util.swing.LogPanel;
import se.trixon.almond.util.swing.dialogs.FileChooserPanel;
import se.trixon.mapollage.profile.Profile;
import se.trixon.mapollage.profile.ProfileSource;

/**
 *
 * @author Patrik Karlsson
 */
public class ModuleSourcePanel extends ModulePanel implements FileChooserPanel.FileChooserButtonListener {

    private ProfileSource mSource;

    /**
     * Creates new form ModuleSourcePanel
     */
    public ModuleSourcePanel() {
        initComponents();
        init();
        mTitle = Dict.SOURCE.toString();
    }

    public FileChooserPanel getSourceChooserPanel() {
        return sourceChooserPanel;
    }

    public void reset() {
        logErrPanel.clear();
        logOutPanel.clear();
        tabbedPane.setSelectedIndex(0);
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public LogPanel getLogErrPanel() {
        return logErrPanel;
    }

    public LogPanel getLogOutPanel() {
        return logOutPanel;
    }

    @Override
    public ImageIcon getIcon() {
        return MaterialIcon._Image.PHOTO_LIBRARY.get(ICON_SIZE, getIconColor());
    }

    @Override
    public boolean hasValidSettings() {
        if (patternTextField.getText().isEmpty()) {
            patternTextField.setText("*");
        }

        if (sourceChooserPanel.getTextField().getText().isEmpty()) {
            invalidSettings(Dict.INVALID_SOURCE.toString());
            return false;
        }

        return true;
    }

    private void init() {
        sourceChooserPanel.setDropMode(FileChooserPanel.DropMode.MULTI);
        sourceChooserPanel.setMode(JFileChooser.FILES_AND_DIRECTORIES);
        sourceChooserPanel.getFileChooser().setMultiSelectionEnabled(true);
        sourceChooserPanel.setButtonListener(this);
        sourceChooserPanel.getTextField().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                saveSourcePath();
            }
        });

        sourceChooserPanel.getTextField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveSourcePath();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saveSourcePath();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveSourcePath();
            }
        });

        patternTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveOption();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveOption();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saveOption();
            }

            private void saveOption() {
                mSource.setFilePattern(patternTextField.getText());
            }
        });

        excludeTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveOption();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveOption();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saveOption();
            }

            private void saveOption() {
                mSource.setExcludePattern(excludeTextField.getText());
            }
        });
    }

    private void saveSourcePath() {
        mSource.setDir(new File(sourceChooserPanel.getPath()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        sourceChooserPanel = new se.trixon.almond.util.swing.dialogs.FileChooserPanel();
        recursiveCheckBox = new javax.swing.JCheckBox();
        followLinksCheckBox = new javax.swing.JCheckBox();
        includeNullCoordinateCheckBox = new javax.swing.JCheckBox();
        tabbedPane = new javax.swing.JTabbedPane();
        logOutPanel = new se.trixon.almond.util.swing.LogPanel();
        logErrPanel = new se.trixon.almond.util.swing.LogPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        patternLabel = new javax.swing.JLabel();
        patternTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        excludeLabel = new javax.swing.JLabel();
        excludeTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("se/trixon/mapollage/ui/config/Bundle"); // NOI18N
        sourceChooserPanel.setHeader(bundle.getString("ModuleSourcePanel.sourceChooserPanel.header")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        add(sourceChooserPanel, gridBagConstraints);

        recursiveCheckBox.setText(Dict.SUBDIRECTORIES.toString());
        recursiveCheckBox.setFocusable(false);
        recursiveCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        recursiveCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recursiveCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(recursiveCheckBox, gridBagConstraints);

        followLinksCheckBox.setText(Dict.FOLLOW_LINKS.toString());
        followLinksCheckBox.setFocusable(false);
        followLinksCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        followLinksCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followLinksCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(followLinksCheckBox, gridBagConstraints);

        includeNullCoordinateCheckBox.setText(bundle.getString("ModuleSourcePanel.includeNullCoordinateCheckBox.text")); // NOI18N
        includeNullCoordinateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                includeNullCoordinateCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(includeNullCoordinateCheckBox, gridBagConstraints);

        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tabbedPane.addTab(Dict.OUTPUT.toString().toLowerCase(), logOutPanel);
        tabbedPane.addTab(Dict.Dialog.ERROR.toString().toLowerCase(), logErrPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(tabbedPane, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        patternLabel.setText(Dict.FILE_PATTERN.toString());
        jPanel1.add(patternLabel);

        patternTextField.setAlignmentX(0.0F);
        jPanel1.add(patternTextField);

        jPanel3.add(jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        excludeLabel.setText(bundle.getString("ModuleSourcePanel.excludeLabel.text")); // NOI18N
        jPanel2.add(excludeLabel);

        excludeTextField.setToolTipText(bundle.getString("ModuleSourcePanel.excludeTextField.toolTipText")); // NOI18N
        excludeTextField.setAlignmentX(0.0F);
        jPanel2.add(excludeTextField);

        jPanel3.add(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void recursiveCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recursiveCheckBoxActionPerformed
        mSource.setRecursive(recursiveCheckBox.isSelected());
    }//GEN-LAST:event_recursiveCheckBoxActionPerformed

    private void followLinksCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followLinksCheckBoxActionPerformed
        mSource.setFollowLinks(followLinksCheckBox.isSelected());
    }//GEN-LAST:event_followLinksCheckBoxActionPerformed

    private void includeNullCoordinateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_includeNullCoordinateCheckBoxActionPerformed
        mSource.setIncludeNullCoordinate(includeNullCoordinateCheckBox.isSelected());
    }//GEN-LAST:event_includeNullCoordinateCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel excludeLabel;
    private javax.swing.JTextField excludeTextField;
    private javax.swing.JCheckBox followLinksCheckBox;
    private javax.swing.JCheckBox includeNullCoordinateCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private se.trixon.almond.util.swing.LogPanel logErrPanel;
    private se.trixon.almond.util.swing.LogPanel logOutPanel;
    private javax.swing.JLabel patternLabel;
    private javax.swing.JTextField patternTextField;
    private javax.swing.JCheckBox recursiveCheckBox;
    private se.trixon.almond.util.swing.dialogs.FileChooserPanel sourceChooserPanel;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void load(Profile profile) {
        mProfile = profile;
        mSource = profile.getSource();

        try {
            sourceChooserPanel.setPath(mSource.getDir().getAbsolutePath());
        } catch (NullPointerException e) {
        }

        patternTextField.setText(mSource.getFilePattern());
        excludeTextField.setText(mSource.getExcludePattern());
        recursiveCheckBox.setSelected(mSource.isRecursive());
        followLinksCheckBox.setSelected(mSource.isFollowLinks());

        includeNullCoordinateCheckBox.setSelected(mSource.isIncludeNullCoordinate());
    }

    @Override
    public void onFileChooserCancel(FileChooserPanel fileChooserPanel) {
        // nvm
    }

    @Override
    public void onFileChooserCheckBoxChange(FileChooserPanel fileChooserPanel, boolean isSelected) {
        // nvm
    }

    @Override
    public void onFileChooserDrop(FileChooserPanel fileChooserPanel) {
        if (fileChooserPanel == sourceChooserPanel) {
            saveSourcePath();
        }
    }

    @Override
    public void onFileChooserOk(FileChooserPanel fileChooserPanel, File file) {
        JFileChooser fileChooser = fileChooserPanel.getFileChooser();

        if (fileChooserPanel == sourceChooserPanel) {
            if (fileChooser.isMultiSelectionEnabled()) {
                String paths = StringUtils.join(fileChooser.getSelectedFiles(), File.pathSeparator);
                fileChooserPanel.setPath(paths);
            }

            saveSourcePath();
        }
    }

    @Override
    public void onFileChooserPreSelect(FileChooserPanel fileChooserPanel) {
        if (fileChooserPanel == sourceChooserPanel) {
            final String[] paths = sourceChooserPanel.getPath().split(File.pathSeparator);
            File[] files = new File[paths.length];

            for (int i = 0; i < files.length; i++) {
                files[i] = new File(paths[i]);
            }

            sourceChooserPanel.getFileChooser().setSelectedFiles(files);
        }
    }
}
