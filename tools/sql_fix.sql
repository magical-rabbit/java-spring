-- 菜单表的修改和完善
INSERT INTO `menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('user-add', '新增用户', 'user-add.html', '2', 28, 2);
UPDATE `menu` SET `menu_url` = 'user-list.html' WHERE `id` = 36;

-- 菜单添加
INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('template-list', '模板列表', 'template-list.html', '2', '40', '1');
-- UPDATE `ovo`.`menu` SET `menu_code` = 'template', `menu_name` = '模板管理' WHERE (`id` = '40');
INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('template-add', '模板新增', 'template.html', '2', '40', '2');


-- 院系
INSERT INTO `menu` (`menu_code`, `menu_name`, `menu_level`, `parent_id`, `sort`) VALUES ('faculty', '院系管理', '1', '0', '1');
INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('faculty-add', '院系添加', 'faculty-add.html', '2', '45', '1');
INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('faculty-list', '院系列表', 'faculty-list.html', '2', '45', '2');


--专业

INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_level`, `parent_id`, `sort`) VALUES ('major', '专业', '1', '0', '1');
INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('major-add', '专业-添加', 'major-add.html', '2', '48', '1');
INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('major-list', '专业列表', 'major-list.html', '2', '48', '2');
