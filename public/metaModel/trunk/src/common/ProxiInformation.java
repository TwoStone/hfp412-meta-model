package common;

public class ProxiInformation {

	private String toString;
	private long classId;
	private long objectId;
	private int iconInfo;
	private int leafInfo;

	private boolean decorator;
	private long decorateeObjectId;
	private long decorateeClassId;
	
	public ProxiInformation(long classId, long objectId, int iconInfo, int leafInfo, String toString) {
		this.classId = classId;
		this.objectId = objectId;
		this.iconInfo = iconInfo;
		this.leafInfo = leafInfo;
		this.toString = toString;
		this.decorator = false;
	}
	public ProxiInformation(long classId, long objectId, int iconInfo, int leafInfo,  String toString, long decorateeClassId, long decorateeObjectID) {
		this.classId = classId;
		this.objectId = objectId;
		this.iconInfo = iconInfo;
		this.leafInfo = leafInfo;
		this.toString = toString;
		this.decorator = true;
		this.decorateeObjectId = decorateeObjectID;
		this.decorateeClassId = decorateeClassId;
	}
	public String getToString() {
		return this.toString;
	}
	public long getClassId() {
		return this.classId;
	}
	public long getObjectId() {
		return this.objectId;
	}
	public int getIconInfo(){
		return this.iconInfo;
	}
	public int getLeafInfo(){
		return this.leafInfo;
	}
	public String getHashKey() {
		return RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getObjectId());
	}
	public long getDecorateeClassId() {
		return decorateeClassId;
	}
	public long getDecorateeObjectId() {
		return decorateeObjectId;
	}
	public boolean isDecorator(){
		return this.decorator;
	}
}
