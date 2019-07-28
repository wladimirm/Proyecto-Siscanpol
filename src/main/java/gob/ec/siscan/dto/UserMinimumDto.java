package gob.ec.siscan.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserMinimumDto {

    @NotNull
    @Pattern(regexp = gob.ec.siscan.dtos.validations.Pattern.NINE_DIGITS)
    private Long id;

    @NotNull
    private String username;

    public UserMinimumDto() {}

    public UserMinimumDto(Long mobile, String username) {
        this.id = mobile;
        this.username = username;
    }

   

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  
}
