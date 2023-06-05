package com.flex.demo.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Sample
 * Package: com.flex.demo.pojo
 * Description:
 *
 * @author candk - 6/5/23 - 11:35 AM
 * @version v1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AnalogSample {
     Date date;
     Float value;
}
