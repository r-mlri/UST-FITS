
package model;
import java.io.Serializable;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


public class studentLog implements Serializable{
	private String SN;
        private String TIMESTAMP;
        private String EQUIPMENTS;

    public String getSN() {
        return SN;
    }
    
    public String getTIMESTAMP() {
        return TIMESTAMP;
    }
    
    public String getEQUIPMENTS() {
        return EQUIPMENTS;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }
    
    public void setTIMESTAMP(String TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }
    
    public void setEQUIPMENTS(String EQUIPMENTS){
        this.EQUIPMENTS = EQUIPMENTS;
    }
    
    	public studentLog() {
	}
        
        public studentLog(String SN, String TIMESTAMP, String EQUIPMENTS) {
                super();
                this.setSN(SN);
                this.setTIMESTAMP(TIMESTAMP);
                this.setEQUIPMENTS(EQUIPMENTS);
    }
    
}
	
