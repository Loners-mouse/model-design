package cn.model.thread.model;

import java.util.Objects;

public class Element {

    private String id;

    private String displayName;

    public Element(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Element element = (Element) o;
        return id.equals(element.id) && displayName.equals(element.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName);
    }

    @Override
    public String toString() {
        return "Element{" + "id='" + id + '\'' + ", displayName='" + displayName + '\'' + '}';
    }
}
