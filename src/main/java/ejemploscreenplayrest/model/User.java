package ejemploscreenplayrest.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class User {
    private String name;
    private String job;

    private User(String name) {
        this.name = name;
    }

    public static User createUserWithName(String name) {
        return new User(name);
    }

    public User withJob(String job) {
        this.job = job;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(getName(), user.getName())
                .append(getJob(), user.getJob())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .append(getJob())
                .toHashCode();
    }
}
