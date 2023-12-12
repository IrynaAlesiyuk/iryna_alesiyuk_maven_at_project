package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChucknorrisJokesResponse {
    private String icon_url;
    private String id;
    private String url;
    private String value;
    private String[] categories;
    private String created_at;
    private String updated_at;

    public ChucknorrisJokesResponse() {

    }
}
