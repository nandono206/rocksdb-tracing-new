// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
//  This source code is licensed under both the GPLv2 (found in the
//  COPYING file in the root directory) and Apache 2.0 License
//  (found in the LICENSE.Apache file in the root directory).

package org.rocksdb;

/**
 * Bloom filter policy that uses a bloom filter with approximately
 * the specified number of bits per key.
 *
 * <p>
 * Note: if you are using a custom comparator that ignores some parts
 * of the keys being compared, you must not use this {@code BloomFilter}
 * and must provide your own FilterPolicy that also ignores the
 * corresponding parts of the keys. For example, if the comparator
 * ignores trailing spaces, it would be incorrect to use a
 * FilterPolicy (like {@code BloomFilter}) that does not ignore
 * trailing spaces in keys.</p>
 */
public class BloomFilter extends Filter {

  private static final double DEFAULT_BITS_PER_KEY = 10.0;

  /**
   * BloomFilter constructor
   *
   * <p>
   * Callers must delete the result after any database that is using the
   * result has been closed.</p>
   */
  public BloomFilter() {
    this(DEFAULT_BITS_PER_KEY);
  }

  /**
   * BloomFilter constructor
   *
   * <p>
   * bits_per_key: bits per key in bloom filter. A good value for bits_per_key
   * is 9.9, which yields a filter with ~ 1% false positive rate.
   * </p>
   * <p>
   * Callers must delete the result after any database that is using the
   * result has been closed.</p>
   *
   * @param bitsPerKey number of bits to use
   */
  public BloomFilter(final double bitsPerKey) {
    super(createNewBloomFilter(bitsPerKey));
  }

  /**
   * BloomFilter constructor
   *
   * <p>
   * bits_per_key: bits per key in bloom filter. A good value for bits_per_key
   * is 10, which yields a filter with ~ 1% false positive rate.
   * <p><strong>default bits_per_key</strong>: 10</p>
   *
   * <p>
   * Callers must delete the result after any database that is using the
   * result has been closed.</p>
   *
   * @param bitsPerKey number of bits to use
   * @param IGNORED_useBlockBasedMode obsolete, ignored parameter
   */
  public BloomFilter(final double bitsPerKey, final boolean IGNORED_useBlockBasedMode) {
    this(bitsPerKey);
  }

  private static native long createNewBloomFilter(final double bitsKeyKey);
}
