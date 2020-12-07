alter table prediction
add column user_data_id bigint
references user_data(id);
