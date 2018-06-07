package cn.hancang.www.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @data 2017/5/31 0031
 * @aurher Administrator
 */
@Entity
public class ProfessionReport {
    @Id
    private String ProfessionId;
    private String ProfessionName;

    @Generated(hash = 1101701817)
    public ProfessionReport(String ProfessionId, String ProfessionName) {
        this.ProfessionId = ProfessionId;
        this.ProfessionName = ProfessionName;
    }

    @Generated(hash = 407214049)
    public ProfessionReport() {
    }

    public String getProfessionId() {
        return this.ProfessionId;
    }

    public void setProfessionId(String ProfessionId) {
        this.ProfessionId = ProfessionId;
    }

    public String getProfessionName() {
        return this.ProfessionName;
    }

    public void setProfessionName(String ProfessionName) {
        this.ProfessionName = ProfessionName;
    }

}
