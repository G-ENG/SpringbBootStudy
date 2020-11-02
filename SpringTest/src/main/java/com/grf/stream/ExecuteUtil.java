package com.grf.stream;

/**
 * TODO
 *
 * @Author GenG
 * @Date 2020/10/27
 **/
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 执行工具类
 *
 * @author 明明如月
 */
public class ExecuteUtil {


    public static <T> void partitionRun(List<T> dataList, int size, Consumer<List<T>> consumer) {
        if (CollectionUtils.isEmpty(dataList)) {
            return;
        }
        Preconditions.checkArgument(size > 0, "size must not be a minus");
        Lists.partition(dataList, size).forEach(consumer);
    }

    public static <T, V> List<V> partitionCall2List(List<T> dataList, int size, Function<List<T>, List<V>> function) {

        if (CollectionUtils.isEmpty(dataList)) {
            return new ArrayList<>(0);
        }
        Preconditions.checkArgument(size > 0, "size must not be a minus");

        return Lists.partition(dataList, size)
                .stream()
                .map(function)
                .filter(Objects::nonNull)
                .reduce(new ArrayList<>(),
                        (resultList1, resultList2) -> {
                            resultList1.addAll(resultList2);
                            return resultList1;
                        });


    }

    public static <T, V> Map<T, V> partitionCall2Map(List<T> dataList, int size, Function<List<T>, Map<T, V>> function) {
        if (CollectionUtils.isEmpty(dataList)) {
            return new HashMap<>(0);
        }
        Preconditions.checkArgument(size > 0, "size must not be a minus");
        return Lists.partition(dataList, size)
                .stream()
                .map(function)
                .filter(Objects::nonNull)
                .reduce(new HashMap<>(),
                        (resultMap1, resultMap2) -> {
                            resultMap1.putAll(resultMap2);
                            return resultMap1;
                        });


    }

    public static <T, V> List<V> partitionCall2ListAsync(List<T> dataList,
                                                         int size,
                                                         ExecutorService executorService,
                                                         Function<List<T>, List<V>> function) {

        if (CollectionUtils.isEmpty(dataList)) {
            return new ArrayList<>(0);
        }
        Preconditions.checkArgument(size > 0, "size must not be a minus");

        List<CompletableFuture<List<V>>> completableFutures = Lists.partition(dataList, size)
                .stream()
                .map(eachList -> {
                    if (executorService == null) {
                        return CompletableFuture.supplyAsync(() -> function.apply(eachList));
                    } else {
                        return CompletableFuture.supplyAsync(() -> function.apply(eachList), executorService);
                    }

                })
                .collect(Collectors.toList());


        CompletableFuture<Void> allFinished = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        try {
            allFinished.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return completableFutures.stream()
                .map(CompletableFuture::join)
                .filter(CollectionUtils::isNotEmpty)
                .reduce(new ArrayList<V>(), ((list1, list2) -> {
                    List<V> resultList = new ArrayList<>();
                    if(CollectionUtils.isNotEmpty(list1)){
                        resultList.addAll(list1);
                    }

                    if(CollectionUtils.isNotEmpty(list2)){
                        resultList.addAll(list2);
                    }
                    return resultList;
                }));
    }
}
