package carrent.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TotalCarList_table")
@Data
public class TotalCarList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
