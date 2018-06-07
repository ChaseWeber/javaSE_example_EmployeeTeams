package managementIT;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProjectTeam {
	private long teamID;
	private String teamName;
	private double payPercent;
	private ArrayList<ProgrammerInCharge> programmers;
	private static ArrayList<ProjectTeam> teamList = new ArrayList<ProjectTeam>();
	
	
	public ProjectTeam(long teamIDInput, String teamNameInput, double payPercentInput) {
		teamID = teamIDInput;		
		teamName = teamNameInput;
		payPercent = payPercentInput;
		programmers = new ArrayList<ProgrammerInCharge>();
		teamList.add(this);
	}
	
	public long getTeamID() {
		return teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getPayPercent() {
		return payPercent;
	}
	public void setPayPercent(double payPercent) {
		this.payPercent = payPercent;
	}
	public ArrayList<ProgrammerInCharge> getProgrammers() {
		return programmers;
	}
	public static ArrayList<ProjectTeam> getTeamList() {
		return teamList;
	}
	
	public void addProgrammer(ProgrammerInCharge programmer) {
		boolean changed;
		changed = programmers.add(programmer);
		System.out.println("ProjectTeam - addProgrammer - " + changed);
	}
	public void removeProgrammer(ProgrammerInCharge programmer) {
		boolean changed;
		changed = programmers.remove(programmer);
		System.out.println("ProjectTeam - removeProgrammer - " + changed);
	}
	@SuppressWarnings("unchecked")
	public JSONObject toJSON() {
		JSONObject teamJSON = new JSONObject();
		teamJSON.put("teamID", teamID);
		teamJSON.put("teamName", teamName);
		teamJSON.put("payPercent", payPercent);
		
		JSONArray programmersJSON = new JSONArray();
		for (ProgrammerInCharge programmer : programmers) {
			programmersJSON.add(programmer.getProgrammerID());
		}
		teamJSON.put("programmerIDs", programmersJSON);
		
		
		JSONObject teamJSONObject = new JSONObject();
		teamJSONObject.put("projectTeam", teamJSON);
		
		return teamJSONObject;
	}
	
}
