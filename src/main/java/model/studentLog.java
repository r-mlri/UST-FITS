
package model;
import java.io.Serializable;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


public class studentLog implements Serializable{
	private String sn;
	private String name;
        private String entrytype;
        private String timestamp;

    public String getSN() {
        return sn;
    }


    public void setSN(String sn) {
        this.sn = sn;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    public String getEntryType() {
        return entrytype;
    }

    public void setEntryType(String entrytype) {
        this.entrytype = entrytype;
    }
    
    public String getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    
    	public studentLog() {
	}
        
        public studentLog(String sn, String name, String entrytype, String temstamp) {
                super();
                this.setSN(sn);
                this.setName(name);
                this.setEntryType(entrytype);
                this.setTimeStamp(timestamp);
    }
    
}
	
