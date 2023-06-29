package Ch_07_Object_Oriented_Design.Q7_11_File_System;

public abstract class Entry {
    protected Directory parent;
    protected long created;
    protected long lastUpdate;
    protected long lastAccessed;
    protected String name;

    public Entry(String name, Directory parent) {
        this.parent = parent;
        this.name = name;
        this.created = System.currentTimeMillis();
        this.lastUpdate = System.currentTimeMillis();
        this.lastAccessed = System.currentTimeMillis();
    }

    public abstract int size();

    public boolean delete() {
        if (parent == null) {
            return false;
        }
        return parent.deleteEntry(this);
    }

    public String getFullPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
