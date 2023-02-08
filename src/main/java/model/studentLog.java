
package model;
import java.io.Serializable;

/**
 *
 * @author Thomas Jefferson Qiu, Ezekiel Giron
 */


public class studentLog implements Serializable{
	private String SN;

    public String getSN() {
        return SN;
    }


    public void setSN(String SN) {
        this.SN = SN;
    }
    
    
    	public studentLog() {
	}
        
        public studentLog(String SN, String name, String entrytype, String temstamp) {
                super();
                this.setSN(SN);
    }
    
}
	
