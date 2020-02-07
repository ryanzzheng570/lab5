package lab5;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_SEQ_GEN")
    @SequenceGenerator(name="PROJECT_SEQ_GEN", sequenceName="PROJECT_SEQ_GEN")
    private Integer Id = null;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = BuddyInfo.class)
    private List<BuddyInfo> bdInfo;

    public AddressBook() { bdInfo = new ArrayList<BuddyInfo>();}
    public AddressBook(ArrayList<BuddyInfo> bdInfo) {
        this.bdInfo = bdInfo;
    }
    public void addNewBuddy(BuddyInfo newBuddy) {
        bdInfo.add(newBuddy);
    }

    public BuddyInfo getBuddy(int index) {
        return this.bdInfo.get(index);
    }

    public List getList() {
        return this.bdInfo;
    }

    public void removeBuddy(BuddyInfo buddy){
        bdInfo.remove(buddy);
    }

    public BuddyInfo findById(int id) {
        for (int i = 0; i< bdInfo.size(); i++) {
            if (bdInfo.get(i).getId() == id) {
                return bdInfo.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<bdInfo.size(); i++) {
            sb.append(bdInfo.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<BuddyInfo> getBdInfo() {
        return bdInfo;
    }

    public void setBdInfo(List<BuddyInfo> bdInfo) {
        this.bdInfo = bdInfo;
    }

    public void removeBuddyInfo() {
        bdInfo = new ArrayList<BuddyInfo>();
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}