package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JsonPlaceHolderModelGet_GetAll_Post_PutResponse {

    int userId;
    int id;
    String title;
    String body;
}
