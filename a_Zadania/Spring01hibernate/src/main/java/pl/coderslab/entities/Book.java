package pl.coderslab.entities;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validators.BookValidationGroup;
import pl.coderslab.validators.PropositionValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = {PropositionValidationGroup.class, BookValidationGroup.class})
    @Size(min = 5, groups = {PropositionValidationGroup.class, BookValidationGroup.class})
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty(groups = {BookValidationGroup.class})
    private List<Author> authors;

    @Min(value = 1, groups = {BookValidationGroup.class})
    @Max(value = 10, groups = {BookValidationGroup.class})
    private int rating;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @NotNull(groups = {BookValidationGroup.class})
    private Publisher publisher;

    @NotBlank(groups = {PropositionValidationGroup.class, BookValidationGroup.class})
    @Size(min = 1, max = 600, groups = {PropositionValidationGroup.class, BookValidationGroup.class})
    private String description;

    @Min(value = 1, groups = {BookValidationGroup.class})
    private int pages;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Category category;

    private boolean proposition;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", rating=" + rating +
                ", publisher=" + publisher +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                '}';
    }
}
