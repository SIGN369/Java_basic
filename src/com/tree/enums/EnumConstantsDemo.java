package com.tree.enums;

/**
 * Author shuqi
 * Rev 
 * Date: Dec 8, 2016 1:00:42 PM
 *
 * Copyright (C) 2016 Seeyon, Inc. All rights reserved.
 *
 * This software is the proprietary information of Seeyon, Inc.
 * Use is subject to license terms.
 * @since v5 v6.1
 */

import java.io.File;
import java.util.Arrays;
import java.util.List;



/**
 * 任务的一些常量定义:定义一个模块的常、枚举这就是很好的参考、、可以学习使用到项目中去
 * 使用了内部类来实现：包含常量+枚举
 * @Copyright 	Copyright (c) 2016
 * @Company 	seeyon.com
 * @since 		v5 v6.1
 */
public class EnumConstantsDemo {
	/**
	 * 任务查看的列表类型
	 */
	public static final String TASK_VIEW_TYPE = "TASK_VIEW_TYPE";
	/**
	 * 任务权限枚举
	 * @Copyright 	Copyright (c) 2016
	 * @Company 	seeyon.com
	 * @since 		v5 v6.1
	 */
	public enum TaskAuthEnums{
		//不要改变每个权限的位置
		//查看、修改、删除、分解、回复、进展、催办、查看日志
		/** 任务查看*/
		View(0,"taskmanage.taskauth.View"),
		/** 任务修改/分解*/
		Update(1,"taskmanage.taskauth.Update"),
		/** 任务删除*/
		Delete(2,"taskmanage.taskauth.Delete"),
		/** 汇报（进展）  */
		Feedback(3,"taskmanage.taskauth.Feedback"),
		/** 催办权限(催办信息放到回复中)  */
		Hasten(4,"taskmanage.taskauth.Hasten"),
		/** 催办权限(催办信息放到回复中)  */
		Decompose(5,"taskmanage.taskauth.Decompose")
		
//		/** 回复 */
//		Reply(5,"taskmanage.taskauth.Reply"),
//		/** 任务分解*/
//		Decompose(6,"taskmanage.taskauth.Decompose"),
//		/** 汇报查看权限 */
//		ViewFeedback(7,"taskmanage.taskauth.ViewFeedback"),
//		/** 回复查看权限  */
//		ViewReply(8,"taskmanage.taskauth.ViewReply"),
//		/** 日志查看权限 */
//		ViewLog(9,"taskmanage.taskauth.ViewLog"),
		;
		/** 本权限对应TaskRoleConfig.roleValue的那个字段 */
		private int index;
		/** 权限的i18n key */
		private String authName;
		private TaskAuthEnums(int index,String authName){
			this.index = index;
			this.authName = authName;
		}
		public int getIndex() {
			return index;
		}
		public String getAuthName() {
			return authName;
		}
	}
	
	/**
	 * 任务默认的角色（6.1暂时用这个）
	 * @Copyright 	Copyright (c) 2016
	 * @Company 	seeyon.com
	 * @since 		v5 v6.1
	 */
	public enum TaskRoleType {
        /** 任务创建者 */
        Creator(0, "common.creater.label"), 
        /** 任务负责人*/
        Manager(1, "taskmanage.manager"), 
        /** 任务参与者 */
        Participator(2, "taskmanage.participator"), 
        /** 任务告知人 */
        inspector(3, "taskmanage.inspector"),
        /** 任务审核人 */
        auditor(4, "taskmanage.auditor"),
        ;

        private int    key;
        private String text;
        
        public String getText() {
            return this.text;
        }
        private TaskRoleType(int key,String text) {
            this.key = key;
            this.text = text;
        }
        
        public int key() {
            return this.key;
        }
        
        /**
         *<p>获取全部的任务类型</p>
         * @return
         * @date   Dec 20, 2016
         * @author shuqi
         * @since  v5 v6.1
         */
        public static Integer[] findAll() {
        	return new Integer[]{Creator.key,Manager.key,Participator.key,inspector.key};
        }
        public static TaskRoleType valueOf(int key) {
        	TaskRoleType[] types = TaskRoleType.values();
            for(TaskRoleType type : types) {
                if(type.key() == key) {
                    return type;
                }
            }
            throw new IllegalArgumentException("[key=" + key + "]");
        }
    }
	
    /** 项目阶段：全部(等价于取项目所有信息)*/
    public static final long    PROJECT_PHASE_ALL         = 1l;
    /** 不与项目关联，作为任务信息项目关联默认值 */
    public static final long    PROJECT_NONE              = -1l;
    /** 没有任务的来源 */
    public static final long    SOURCE_NONE               = -1l;
    /** 没有上级任务 */
    public static final long    PARENT_TASK_NONE          = -1l;
    /*** 任务ID为空时，默认的任务Id */
    public static final long    TASK_DEFAULT_ID           = -1l;
    /*** 不提醒  */
    public static final int     NO_REMIND                 = -1;
    /*** 任务审核人为空  */
    public static final long    AUDITOR_NONE           	  = -1l;
    
	/** 重要程度 - 普通，值为1*/
	public static final int     IMPORTANCE_COMMON         = 1;
	/** 重要程度 - 重要，值为2 */
	public static final int     IMPORTANCE_IMPORTANT      = 2;
	/** 重要程度 - 非常重要，值为3*/
	public static final int     IMPORTANCE_VERY_IMPORTANT = 3;
	
	/**
	 * 任务列表枚举
	 * @Copyright 	Copyright (c) 2016
	 * @Company 	seeyon.com
	 * @since 		v5 v6.1
	 * @author		shuqi
	 */
	public enum TaskListType{
		/** 告知我的 */
		TellMe,
		/** 我分派的 */
		Sent,
		/** 我的任务 */
		Personal,
		/** 他人任务（他人负责的，参与的任务） */
		Manage,
		/** 项目任务列表  */
		ProjectTask,
		/** 会议任务  */
		MeetingTask,
		/** 任务审核  */
		TaskAudit
	}
	
    /**
     * 提醒类型：任务开始前提醒提醒、任务结束前提前提醒
     * @author <a href="mailto:yangm@seeyon.com">Rookie Young</a> 2011-2-28
     */
    public static enum RemindType {
        /**
         * 任务开始前提醒提醒
         */
        BeforeStart,
        /**
         * 任务结束前提前提醒
         */
        BeforeEnd;

        public static RemindType valueOf(int key) {
            RemindType[] types = RemindType.values();
            for (RemindType type : types) {
                if (type.ordinal() == key) {
                    return type;
                }
            }
            throw new IllegalArgumentException("taskmanage.label.wrongfulness");
        }
    }
    
    /**
     * 任务查询条件枚举
     * @Copyright 	Copyright (c) 2016
     * @Company 	seeyon.com
     * @since 		v5 v6.1
     * @author		shuqi
     */
    public enum TaskStatusCondition implements EnumsCode{
    	/** 全部  */
        all(-1, "taskmanage.all"),
        /** 未完成  */
        unfinished(-2, "taskmanage.status.unfinished"),
        /** 进行中  */
        marching(2, "taskmanage.status.marching"),
        /** 未开始  */
        notstarted(1, "taskmanage.status.notstarted"),
        /** 已超期  */
        overdue(6, "taskmanage.overdue.yes"),
        /** 已完成  */
        finished(4, "taskmanage.status.finished"), 
        /** 已取消  */
        canceled(5, "taskmanage.status.canceled");
        
        private int    key;
        private String text;

        TaskStatusCondition(int key, String text) {
            this.key = key;
            this.text = text;
        }

        public int getKey() {
            return key;
        }
        @Override
        public String getText() {
            return this.text;
        }
        @Override
        public String getValue() {
            return String.valueOf(key);
        }
        
        public static TaskStatusCondition findByKey(int key) {
        	TaskStatusCondition[] enums = TaskStatusCondition.values();
        	TaskStatusCondition statusEnum = null;
            if (enums != null && enums.length != 0) {
                for(int i=0;i<enums.length;i++){
                    if(key == enums[i].getKey()){
                        statusEnum = enums[i];
                    }
                }
            }
            return statusEnum;
        }
      
    
    /** rest list all task */
    public final static String REST_ALL = "all";
    /** rest list unfinished task */
    public final static String REST_UNFINISHED = "unfinished";
    /** rest list overdue task */
    public final static String REST_OVERDUE = "overdue";
    /** rest list this week unfinished task */
    public final static String REST_WEEK_UNFINISHED = "weekunfinished";
    /** 项目任务统计中，对所有人员的任务统计求和时不能简单累加，需要单独查询获取合计结果，用此标识 */
    public static final Long    STATISTIC_SUM_MEMBERS     = -1l;
    
    /**
     * 任务权限类型枚举，包括：新建、分解任务、修改、查看、回复、汇报、任务树中穿透查看子任务
     * 
     */
    public static enum TaskAclEnum {
        /** 新建任务 */
        Add,
//        /** 通过分解新建子任务 */
        Decompose,
        /** 修改任务 */
        Edit,
//        /** 删除任务 */
//        Delete,
//        /** 查看任务 */
//        View,
//        /** 回复任务 */
//        Reply,
//        /** 任务汇报  */
//        Feedback,
//        /**任务树中穿透查看子任务*/
//        TreeTaskDetails
    }
    
    /**
     * 任务自定义排序设置KEY
     */
    public static final String taskList_Customize_Key = "task_list_order";
    public static final String taskList_default_order = "status_asc,plannedEndTime_asc";

    /**
     * 任务审核KEY
     */
    public static final String TASK_AUDIT_KEY = "task_audit";
    /**
     * <p>任务审核状态枚举</p>
     * @copyright 	Copyright (c) 2017
     * @company		seeyon.com
     * @date		Nov 15, 2017 4:09:12 PM
     * @since		V5 V7.0
     * @author      shuqi
     */
    public enum TaskAuditStatus implements EnumsCode{
    	Auditing(0,"taskmanage.TaskAuditStatus.Auditing.js"),//待审核
    	Pass(1,"taskmanage.TaskAuditStatus.Pass.js"),//审核通过
    	NotPass(2,"taskmanage.TaskAuditStatus.NotPass.js");//审核不通过
    	
        private int    key;
        private String text;
        TaskAuditStatus(int key, String text) {
            this.key = key;
            this.text = text;
        }
		@Override
		public String getValue() {
			return String.valueOf(this.key);
		}
		@Override
		public String getText() {
			return this.text;
		}
		public String getAuditText() {
			String label = "";
			switch (this) {
				case Auditing:
					label = this.text;
					break;
				case Pass:
					label = "";
					break;
				case NotPass:
					label = "";
					break;
				default:
					break;
			}
			return label;
		}
		public int getKey() {
			return key;
		}

		public static TaskAuditStatus getValueByKey(int key){
            TaskAuditStatus[] enums = TaskAuditStatus.values();
            for(TaskAuditStatus e : enums){
                if(e.getKey() == key){
                    return e;
                }
            }
            return null;
        }
    	
    }
    /**
     * <p>任务审核类型</p>
     * @copyright 	Copyright (c) 2017
     * @company		seeyon.com
     * @date		Nov 16, 2017 9:16:55 AM
     * @since		V5 V7.0
     * @author      shuqi
     */
    public enum TaskAuditType implements EnumsCode {
		CreateTask(0,"taskmanage.TaskAuditType.CreateTask.js"),//新建任务
		UpdateTask(1,"taskmanage.TaskAuditType.UpdateTask.js"),//修改任务
		CancelTask(2,"taskmanage.TaskAuditType.CancelTask.js"),//取消任务
		FinishTask(3,"taskmanage.TaskAuditType.FinishTask.js"),//完成任务
		;
	    private int    key;
        private String text;
        TaskAuditType(int key, String text) {
            this.key = key;
            this.text = text;
        }
		@Override
		public String getValue() {
			return String.valueOf(this.key);
		}
		@Override
		public String getText() {
			return this.text;
		}
		public int getKey() {
			return key;
		}

        public static TaskAuditType getValueByKey(Integer key){
            TaskAuditType[] enums = TaskAuditType.values();
            for(TaskAuditType e : enums){
                if(e.getKey() == key){
                    return e;
                }
            }
            return null;
        }
    }
    
    public enum TaskMessageFliterKey{
		/** 新建任务 */
	    CreateTask(1),
	    /** 更新任务 */
        UpdateTask(1),
        /** 删除任务 */
        DeleteTask(1),
        /** 新建汇报 */
        CreateFeedback(2),
        /** 更新汇报 */
        UpdateFeedback(2),
        /**自动汇报 */
        AutoCreateFeedback(2),
        /** 自动新建任务？  */
        AutoCreateTask(2),
        /** 自动删除任务？  */
        AutoDeleteTask(2),
        /** 自动修改任务？  */
        AutoModifyTask(2),
        /** 回复任务 */
        ReplyTask(3),
        /**  */
        RefrenceReply(3),
        /** 新建任务 */
        RemindBeforeStart(4),
        /** 新建任务 */
        RemindBeforeEnd(4),
        /** 新建任务发送消息给审核人 */
        CreateTask2Auditor(5),
        /** 审核人审核消息  */
        AuditMessage(6),
        ;
	    private int fliterKey;
	    TaskMessageFliterKey(int fliterKey){
	   	  this.fliterKey = fliterKey;
	    }
		/**
		 * @return 消息过滤的Key
		 * @date	Nov 17, 2017 10:38:45 AM
		 * @since	V5 V7.0
		 * @author  shuqi
		 */
		public String getKeyString() {
			return String.valueOf(fliterKey);
		}
    }
    } 
}
