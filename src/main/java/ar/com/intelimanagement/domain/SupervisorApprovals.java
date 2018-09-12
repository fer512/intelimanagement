package ar.com.intelimanagement.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ar.com.intelimanagement.domain.enumeration.ApprovalsStatusType;

/**
 * A Supervisor Approvals.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@DiscriminatorValue("SUPERVISOR")
public class SupervisorApprovals extends Approvals implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="approve_level")
	private Integer approveLevel = 1;
	
	private Approvals approveOK(User user) {
		User userCurrentLevel = this.getUserCurrentLevel();
		User supervisor = userCurrentLevel.getSupervisor();
		if(user.getId().equals(supervisor.getId())){
			ApprovalHistory history = new ApprovalHistory();
			history.setStatus(ApprovalsStatusType.APPOVED);
			history.setUser(user);
			this.getHistory().add(history);
			if(this.approveLevel.equals(this.getHistory().size())) {
				this.setStatus(ApprovalsStatusType.APPOVED);
			}
		}

		//throw
		return null;
	}
	
	private Integer getCurrentLevel() {
		return this.getHistory().size();
	}
	
	private User getUserCurrentLevel() {
		Integer currentLevel = this.getCurrentLevel();
		if(currentLevel.equals(0)) {
			return null;//this.getCreatedBy();
		}else {
			return this.getHistory().get(currentLevel).getUser();
		}
	}

	public List<User> getUserByNextLevel() {
		 List<User> list =  new ArrayList<User>();
		 User supervisor = this.getHistory().get(this.getHistory().size() - 1).getUser().getSupervisor();
		 if(supervisor == null) {
			 
		 }
		 list.add(supervisor);
		 return list;
	}

	public Integer getApproveLevel() {
		return approveLevel;
	}

	public void setApproveLevel(Integer approveLevel) {
		this.approveLevel = approveLevel;
	}
	
	
}