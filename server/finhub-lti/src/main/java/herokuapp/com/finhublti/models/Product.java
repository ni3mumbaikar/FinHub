package herokuapp.com.finhublti.models;

public class Product {
    String pname, pdesc, pimage;
    long is3, is6, is9, is12, pid;

    public Product() {
    }

    public Product(String pname, String pdesc, String pimage, long is3, long is6, long is9, long is12, long pid) {
        this.pname = pname;
        this.pdesc = pdesc;
        this.pimage = pimage;
        this.is3 = is3;
        this.is6 = is6;
        this.is9 = is9;
        this.is12 = is12;
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public long getIs3() {
        return is3;
    }

    public void setIs3(long is3) {
        this.is3 = is3;
    }

    public long getIs6() {
        return is6;
    }

    public void setIs6(long is6) {
        this.is6 = is6;
    }

    public long getIs9() {
        return is9;
    }

    public void setIs9(long is9) {
        this.is9 = is9;
    }

    public long getIs12() {
        return is12;
    }

    public void setIs12(long is12) {
        this.is12 = is12;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }
}
