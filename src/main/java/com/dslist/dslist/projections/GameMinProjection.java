package com.dslist.dslist.projections;

public interface GameMinProjection {
    // tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
    //		tb_game.short_description AS shortDescription, tb_belonging.position
    Long getId();
    String  getTitle();
    Integer getYear();
    String  getImgUrl();
    String  getShortDescription();
    Integer getPosition();

}
