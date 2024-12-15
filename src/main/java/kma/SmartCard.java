/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kma;

import java.awt.Font;
import java.awt.HeadlessException;
import java.math.BigInteger;
import java.util.List;
import javax.smartcardio.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Judy
 */
public class SmartCard {

    public static final byte[] AID_APPLET = {(byte) 0x55, (byte) 0x44, (byte) 0x33, (byte) 0x22, (byte) 0x11, (byte) 0x00};//aid
    private Card card;
    private TerminalFactory factory;
    private CardChannel channel;
    private CardTerminal terminal;
    private List<CardTerminal> terminals;
    private ResponseAPDU response;
    public SmartCard() {
    }

    public static void main(String[] args) {

    }

    public boolean connectCard() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return false;
            }
            response = channel.transmit(new CommandAPDU(0x00, (byte) 0xA4, 0x04, 0x00, AID_APPLET));
            String check = Integer.toHexString(response.getSW());
            switch (check) {
                case "9000" -> {
                    return true;
                }
                case "6400" -> {
                    JOptionPane.showMessageDialog(null, "Thẻ đã bị khóa");
                    return true;
                }
                default -> {
                    return false;
                }
            }
        } catch (HeadlessException | CardException e) {
        }
        return false;
    }

    public String login(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return "0";
            }
            System.err.println("ok" + data.length);
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x02, (byte) 0x01, (byte) 0x01, data));
            String check = Integer.toHexString(response.getSW());
            String res = String.format("%x", new BigInteger(1, response.getData()));
            System.out.println(check+res);
            return res;

        } catch (Exception e) {
            System.out.println(e);
              return "0";
        }
    }

    public String unblockcard(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return "0";
            }
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x03, (byte) 0x01, (byte) 0x01, data));
            String check = Integer.toHexString(response.getSW());
            System.out.println("check " + check);
            String res = String.format("%x", new BigInteger(1, response.getData()));
            return res;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "0";
    }

    public boolean uploadAvatar(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);

            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return false;
            }
            String dataLc = String.valueOf(data.length);

            System.out.println("ok " + String.format("%x", new BigInteger(1, data)));
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x08, (byte) 0x01, (byte) 0x01, data));
            System.out.println("response " + response);
            String check = Integer.toHexString(response.getSW());
            if (check.equals("9000")) {
                return true;
            } else if (check.equals("6400")) {
                JOptionPane.showMessageDialog(null, "Upload that bai");
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public String getAvatar() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x09, (byte) 0x01, (byte) 0x01));
            System.out.println("response " + response);
            String res = String.format("%x", new BigInteger(1, response.getData()));
            String check = Integer.toHexString(response.getSW());
            if (check.equals("9000")) {
                return res;
            } else if (check.equals("6A83")) {
                return "";
            } else {
                return "";
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    public String checkCard() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return "0";
            }
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x07, (byte) 0x01, (byte) 0x01));
            System.out.println("response " + response.getData());
            String res = String.format("%x", new BigInteger(1, response.getData()));
            return res;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "0";
        }
    }

    public boolean initCard(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return false;
            }
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x01, (byte) 0x01, (byte) 0x01, data));
            System.out.println("response " + response);
            String check = Integer.toHexString(response.getSW());
            if (check.equals("9000")) {
                return true;
            } else if (check.equals("6400")) {
                JOptionPane.showMessageDialog(null, "Upload that bai");
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public String getInfo() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x06, (byte) 0x01, (byte) 0x01));

            String res = String.format("%x", new BigInteger(1, response.getData()));
            System.out.println("response " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    public String getId() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x15, (byte) 0x01, (byte) 0x01));

            String res = String.format("%x", new BigInteger(1, response.getData()));
            System.out.println("response " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    public boolean changeInfo(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return false;
            }
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x05, (byte) 0x01, (byte) 0x01, data));
            System.out.println("response " + response);
            String check = Integer.toHexString(response.getSW());
            if (check.equals("9000")) {
                return true;
            } else if (check.equals("6400")) {
                JOptionPane.showMessageDialog(null, "Update that bai");
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public boolean changePin(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return false;
            }
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x04, (byte) 0x01, (byte) 0x01, data));
            System.out.println("response " + response);
            String check = Integer.toHexString(response.getSW());
            if (check.equals("9000")) {
                return true;
            } else if (check.equals("6984")) {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 24)));
                JOptionPane.showMessageDialog(null, "Nhập sai mã pin, mời nhập lại!", "", JOptionPane.INFORMATION_MESSAGE);
                return false;
            } else {
                return false;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public BigInteger getModulusPubkey() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x10, (byte) 0x01, (byte) 0x01));

            BigInteger res = new BigInteger(1, response.getData());
            System.out.println("responseM " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public BigInteger getExponentPubkey() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x10, (byte) 0x02, (byte) 0x01));

            BigInteger res = new BigInteger(1, response.getData());
            System.out.println("responseE " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public String getRandomData() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x12, (byte) 0x01, (byte) 0x01));

            String res = String.format("%x", new BigInteger(1, response.getData()));
            System.out.println("response " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    public String getSign(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x11, (byte) 0x01, (byte) 0x01, data));
            String check = Integer.toHexString(response.getSW());
            if (check.equals("9000")) {
                String res = String.format("%x", new BigInteger(1, response.getData()));
                System.out.println("response " + res);
                return res;
            } else if (check.equals("6984")) {
                return "";
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    //check money + score
    public String checkScore() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x12, (byte) 0x01, (byte) 0x01));

            String res = String.format("%x", new BigInteger(1, response.getData()));
            System.out.println("response " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    //account balance
    public boolean accountBalance(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            if (channel == null) {
                return false;
            }
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x13, (byte) 0x13, (byte) 0x01, data));
            System.out.println("response " + response);
            String check = Integer.toHexString(response.getSW());
            if (check.equals("9000")) {
                return true;
            } else if (check.equals("6f00")) {
                JOptionPane.showMessageDialog(null, "Lỗi nạp tiền!");
                return false;
            } else {
                return false;
            }

        } catch (Exception e) {
        }
        return false;
    }
    //pay 

    public String pay(byte[] data) {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("T=0");
            channel = card.getBasicChannel();
            response = channel.transmit(new CommandAPDU((byte) 0x00, (byte) 0x14, (byte) 0x01, (byte) 0x01, data));

            String res = String.format("%x", new BigInteger(1, response.getData()));
            System.out.println("response " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    //format
    public String stringToHex(String string) {
        StringBuilder buf = new StringBuilder(200);
        for (char ch : string.toCharArray()) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append(String.format("%04x", (int) ch));
        }
        return buf.toString();
    }

    public byte[] hexStringToByteArray(String s) {
        int len = s.length();
        System.out.println("len " + len);
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public boolean disconnect() {
        try {
            card.disconnect(false);
            return true;
        } catch (Exception e) {
            System.err.println("Loi: " + e);
        }
        return false;
    }

}
