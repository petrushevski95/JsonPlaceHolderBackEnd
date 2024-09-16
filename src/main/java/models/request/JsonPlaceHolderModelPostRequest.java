package models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JsonPlaceHolderModelPostRequest {

    String title;
    String body;
    int userId;
}
