package com.ares.infrastructure.pattern.state;

import java.util.Date;

/**
 * 作业
 *
 * @author  0xZzzz
 * @date 2020/11/4
 */
public class Task {

    /**
     * 作业批次ID
     */
    private Long id;

    /**
     * 作业批次状态
     */
    private TaskStatus status;

    /**
     * 操作人ID
     */
    private String operatorId;

    /**
     * 实际开始时间
     */
    private Date actualStartTime;

    /**
     * 实际结束时间
     */
    private Date actualEndTime;

    /**
     * 领取作业
     */
    private void claimedBy(String operatorId) {
        if (status != TaskStatus.CREATED) {
            if (status == TaskStatus.CLOSED) {
                throw new RuntimeException("该作业已取消，不能领取！");
            }
            if (status == TaskStatus.FINISHED) {
                throw new RuntimeException("该作业已完成，不能领取！");
            }
            if (status == TaskStatus.STARTED) {
                throw new RuntimeException("该作业正在执行中，不能领取！");
            }
            if (status == TaskStatus.CLAIMED && !operatorId.equals(this.operatorId)) {
                throw new RuntimeException("该作业被其他人领取！");
            }
        }
        this.operatorId = operatorId;
        status = TaskStatus.CLAIMED;
    }

    /**
     * 开始作业
     */
    private void start(String operatorId, Date actualStartTime) {
        if (status != TaskStatus.CLAIMED) {
            if (status == TaskStatus.CLOSED) {
                throw new RuntimeException("该作业已取消，不能执行！");
            }
            if (status == TaskStatus.FINISHED) {
                throw new RuntimeException("该作业已完成，无需再次执行！");
            }
            if (status == TaskStatus.STARTED) {
                throw new RuntimeException("该作业正在执行中，无需再次执行！");
            }
            if (status == TaskStatus.CREATED) {
                throw new RuntimeException("该作业还未被认领，请领取后再执行！");
            }
        }
        if (!operatorId.equals(this.operatorId)) {
            throw new RuntimeException("您不能执行他人领取的作业！");
        }
        // 作业执行逻辑 ...
        status = TaskStatus.STARTED;
        this.actualStartTime = actualStartTime;
    }

    /**
     * 完成作业
     */
    private void finish(String operatorId, Date actualEndTime) {
        if (status != TaskStatus.STARTED) {
            if (status == TaskStatus.CLOSED) {
                throw new RuntimeException("该作业已取消，不能完成！");
            }
            if (status == TaskStatus.FINISHED) {
                throw new RuntimeException("该作业已完成！");
            }
            if (status == TaskStatus.CLAIMED) {
                throw new RuntimeException("该作业还未执行！");
            }
            if (status == TaskStatus.CREATED) {
                throw new RuntimeException("该作业还未被认领！");
            }
        }
        if (!operatorId.equals(this.operatorId)) {
            throw new RuntimeException("您不能完成他人领取的作业！");
        }
        // 作业完成逻辑 ...
        status = TaskStatus.FINISHED;
        this.actualEndTime = actualEndTime;
    }

}
