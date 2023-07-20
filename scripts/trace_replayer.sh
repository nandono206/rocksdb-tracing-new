../cmake-build-debug/db_bench --benchmarks=replay --use_existing_db=true --db="/tmp/block_cache_trace" \
--trace_file=/tmp/op_trace_file --num_column_families=1 --perf_level=2 \
--use_direct_io_for_flush_and_compaction=true --use_direct_reads=true