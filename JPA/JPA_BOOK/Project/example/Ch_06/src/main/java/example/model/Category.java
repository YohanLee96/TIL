package example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "CATEGORY")
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    @OneToMany(mappedBy = "category")
    private List<CategoryItem> categoryItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();


    @Column(name = "NAME")
    private String name;

    @Builder
    public Category(List<CategoryItem> categoryItems, String name) {
        this.categoryItems = categoryItems;
        this.name = name;
    }

    public void setParent(Category category) {
        this.parent = category;
    }

    public void addChildCategory(Category childCategory) {
        this.child.add(childCategory);
        //하위 카테고리에도 저장
        childCategory.setParent(this);
    }
}
